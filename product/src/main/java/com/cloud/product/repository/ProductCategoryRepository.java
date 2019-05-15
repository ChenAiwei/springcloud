package com.cloud.product.repository;

import com.cloud.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/14 21:01
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}
