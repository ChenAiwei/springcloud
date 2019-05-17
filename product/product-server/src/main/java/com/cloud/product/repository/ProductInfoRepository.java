package com.cloud.product.repository;

import com.cloud.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/14 16:05
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
	/**
	 * 根据产品状态返回产品列表
	 * @param status
	 * @return
	 */
	List<ProductInfo> findByProductStatus(Integer status);
}

