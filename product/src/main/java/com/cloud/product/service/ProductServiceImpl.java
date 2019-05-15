package com.cloud.product.service;

import com.cloud.product.entity.ProductCategory;
import com.cloud.product.entity.ProductInfo;
import com.cloud.product.repository.ProductCategoryRepository;
import com.cloud.product.repository.ProductInfoRepository;
import com.cloud.product.vo.ProductInfoVo;
import com.cloud.product.vo.ProductResultVo;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 8:38
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductResultVo> listAll() {
		List<ProductResultVo> resultVoList = new ArrayList<>();
		List<ProductCategory> productCategoryList = productCategoryRepository.findAll();
		List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
		productCategoryList.forEach(productCategory -> {
			ProductResultVo productResultVo = new ProductResultVo();
			BeanUtils.copyProperties(productCategory,productResultVo);
			List<ProductInfoVo> foods = new ArrayList<>();
			productInfoList.forEach(productInfo -> {
				if(productCategory.getCategoryType().equals(productInfo.getCategoryType())){
					ProductInfoVo productInfoVo = new ProductInfoVo();
					BeanUtils.copyProperties(productInfo,productInfoVo);
					foods.add(productInfoVo);
				}
			});
			productResultVo.setFoods(foods);
			resultVoList.add(productResultVo);
		});
		return resultVoList;
	}
}
