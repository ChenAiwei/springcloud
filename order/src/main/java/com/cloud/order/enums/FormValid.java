package com.cloud.order.enums;

import lombok.Getter;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 14:26
 */
@Getter
public enum FormValid {

	PARM_ERROR(-1,"参数不正确");

	private  Integer code;
	private String message;

	FormValid(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
