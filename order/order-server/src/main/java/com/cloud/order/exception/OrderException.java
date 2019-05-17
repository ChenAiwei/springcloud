package com.cloud.order.exception;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 14:21
 */
public class OrderException extends RuntimeException{

	private Integer code;

	public  OrderException(Integer code,String message){
		super(message);
		this.code = code;
	}
}
