package com.cloud.product.enums;

import lombok.Getter;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 14:26
 */
@Getter
public enum Error {

	PARM_ERROR(-1,"参数不正确"),
	BUSINESS_ERROR(-2,"其他错误");

	private  Integer code;
	private String message;

	Error(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
