package com.cloud.product.service;

import com.cloud.poruct.dto.ProductDetailDto;
import com.cloud.poruct.vo.ProductDetailVo;
import com.cloud.poruct.vo.ProductResultVo;

import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 8:38
 */
public interface ProductService {
	/**
	 * 查询所有商品信息
	 * @return
	 */
	List<ProductResultVo> listAll();

	/**
	 * 订单扣库存
	 * @param productDetailDtoList
	 * @return
	 */
	List<ProductDetailVo> reduceProduct(List<ProductDetailDto> productDetailDtoList) throws Exception;
}
