package com.cloud.poruct.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author：aiwei
 * @Description：下单扣库存返回的商品信息
 * @CreateDate：2019/5/17 14:14
 */
@Data
public class ProductDetailVo {
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer count;
	private String productDescription;
	private String productIcon;
	private Integer productStatus;
	private Integer categoryType;
}
