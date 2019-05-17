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
	@NotEmpty(message = "productId不能为空")
	private String productId;
	@NotEmpty(message = "productQuantity不能为空")
	private String productQuantity;
}
