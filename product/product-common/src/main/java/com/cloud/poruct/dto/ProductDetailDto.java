package com.cloud.poruct.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author：aiwei
 * @Description：下单扣库存请求实体
 * @CreateDate：2019/5/17 14:13
 */
@Data
public class ProductDetailDto {
	/**
	 * 产品ID
	 */
	@NotEmpty(message = "productId不能为空")
	private  String productId;
	/**
	 * 购买数量
	 */
	@NotNull(message = "count不能为空")
	@Min(value = 1,message = "count 最小为1")
	private  Integer count;
}
