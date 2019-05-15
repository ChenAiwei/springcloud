package com.cloud.order.service;

import com.cloud.order.dto.CreateOrderDto;
import com.cloud.order.entity.OrderMaster;
import com.cloud.order.enums.OrderStatus;
import com.cloud.order.enums.PayStatus;
import com.cloud.order.repository.OrderDetailRepository;
import com.cloud.order.repository.OrderMasterRepository;
import com.cloud.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 11:27
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	private OrderDetailRepository orderDetailRepository;

	@Override
	public CreateOrderDto createOrder(CreateOrderDto dto) {
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
		dto.setOrderId(orderId);
		return dto;
	}
}
