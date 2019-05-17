package com.cloud.order.enums;

import lombok.Getter;

/**
 * 支付状态枚举类
 */
@Getter
public enum PayStatus {
	WAIT(0,"待支付"),
	SUCCESS(1,"支付成功"),
	FAIL(2,"支付失败");

	private Integer code;
	private String message;

	PayStatus(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
