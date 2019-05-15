package com.cloud.order.vo;

import lombok.Data;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 9:12
 */
@Data
public class ResultVo<T> {
	private Integer code;
	private String msg;
	private T data;
}
