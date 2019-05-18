package com.cloud.poruct.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 8:50
 */
@Data
public class ProductResultVo {

	@JsonProperty("name")
	private  String categoryName;

	@JsonProperty("type")
	private  Integer categoryType;

	private List<ProductInfoVo> foods;
}
