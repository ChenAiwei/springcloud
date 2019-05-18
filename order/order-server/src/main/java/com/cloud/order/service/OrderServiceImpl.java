package com.cloud.order.service;

import com.cloud.order.dto.CreateOrderDto;
import com.cloud.order.entity.OrderDetail;
import com.cloud.order.entity.OrderMaster;
import com.cloud.order.enums.OrderStatus;
import com.cloud.order.enums.PayStatus;
import com.cloud.order.repository.OrderDetailRepository;
import com.cloud.order.repository.OrderMasterRepository;
import com.cloud.order.utils.KeyUtil;
import com.cloud.poruct.vo.ProductDetailVo;
import com.cloud.poruct.vo.ResultVo;
import com.cloud.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 11:27
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductClient productClient;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CreateOrderDto  createOrder(CreateOrderDto dto) throws Exception {
		//根据产品ID扣库存，返回产品详情，入库订单详情
		ResultVo<List<ProductDetailVo>> listResultVo = null;
		try {
			listResultVo = productClient.reduceProduct(dto.getItems());
		}catch (Exception e){
			log.error("调用Product服务异常："+e);
			throw new Exception("调用Product服务异常");
		}
		if(CollectionUtils.isEmpty(listResultVo.getData()) && listResultVo.getCode()!=0){
			throw new Exception(listResultVo.getMsg());
		}
		OrderMaster orderMaster = new OrderMaster();
		String orderId = KeyUtil.genUinqueKey();
		orderMaster.setOrderId(orderId);
		orderMaster.setBuyerName(dto.getName());
		orderMaster.setBuyerPhone(dto.getPhone());
		orderMaster.setBuyerAddress(dto.getAddress());
		orderMaster.setBuyerOpenid(dto.getOpenid());
		orderMaster.setOrderAmount(BigDecimal.valueOf(50));
		orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
		orderMaster.setPayStatus(PayStatus.WAIT.getCode());
		orderMasterRepository.save(orderMaster);
		listResultVo.getData().forEach(productDetailVo -> {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setDetailId(KeyUtil.genUinqueKey());
			orderDetail.setOrderId(orderId);
			orderDetail.setProductId(productDetailVo.getProductId());
			orderDetail.setProductName(productDetailVo.getProductName());
			orderDetail.setProductPrice(productDetailVo.getProductPrice());
			orderDetail.setProductQuantity(productDetailVo.getCount());
			orderDetail.setProductIcon(productDetailVo.getProductIcon());
			orderDetailRepository.save(orderDetail);
		});
		dto.setOrderId(orderId);
		return dto;
	}
}
