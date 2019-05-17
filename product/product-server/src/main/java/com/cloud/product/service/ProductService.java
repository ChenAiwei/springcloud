package com.cloud.product.service;

import com.cloud.product.vo.ProductResultVo;

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
}
