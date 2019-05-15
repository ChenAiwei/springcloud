package com.cloud.order.service;

import com.cloud.order.dto.CreateOrderDto;

/**
 * @author aiwei
 */
public interface OrderService {
	/**
	 * 订单创建
	 * @param dto
	 */
	CreateOrderDto  createOrder(CreateOrderDto dto);
}
