package com.cloud.order.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 15:15
 */
@Data
public class OrderItem {
	private String productId;
	private String productQuantity;
}
