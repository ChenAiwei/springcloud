package com.cloud.order.controller;

import com.cloud.order.dto.CreateOrderDto;
import com.cloud.order.enums.FormValid;
import com.cloud.order.service.OrderService;
import com.cloud.order.utils.ResultVoUtil;
import com.cloud.order.vo.ResultVo;
import com.cloud.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 14:04
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductClient productClient;

	@PostMapping("/create")
	public ResultVo<HashMap<String,String>> create(@Valid @RequestBody CreateOrderDto orderForm, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			log.error("创建订单参数不正确，orderForm={}",orderForm);
			return ResultVoUtil.error(FormValid.PARM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
		}
		CreateOrderDto order = null;
		try {
			order = orderService.createOrder(orderForm);
		}catch (Exception e){
			return ResultVoUtil.error(-1,e.getMessage());
		}
		Map<String,String> resultMap = new HashMap<>();
		resultMap.put("orderId",order.getOrderId());
		return ResultVoUtil.success(resultMap);
	}

	@GetMapping("/getProductMsg")
	public String getProductMsg(){
		String msg = productClient.getProductMsg();
		log.info(msg);
		return msg;
	}
}
