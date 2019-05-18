package com.cloud.poruct.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 8:40
 */
@Data
public class ProductInfoVo {

	@JsonProperty("id")
	private String productId;

	@JsonProperty("name")
	private String productName;

	@JsonProperty("price")
	private BigDecimal productPrice;

	@JsonProperty("description")
	private String productDescription;

	@JsonProperty("icon")
	private String productIcon;

}
