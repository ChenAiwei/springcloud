package com.cloud.order.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 11:23
 */
@Data
public class CreateOrderDto {
	@NotEmpty(message = "姓名不能为空")
	private String name;
	@NotEmpty(message = "手机号不能为空")
	private String phone;
	@NotEmpty(message = "地址不能为空")
	private String address;
	@NotEmpty(message = "openid不能为空")
	private String openid;
	@Valid
	private List<OrderItem> items;
	private String orderId;
}
