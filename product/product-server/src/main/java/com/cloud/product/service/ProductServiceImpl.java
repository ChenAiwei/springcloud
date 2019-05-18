package com.cloud.product.service;

import com.cloud.poruct.dto.ProductDetailDto;
import com.cloud.poruct.vo.ProductDetailVo;
import com.cloud.poruct.vo.ProductInfoVo;
import com.cloud.poruct.vo.ProductResultVo;
import com.cloud.product.entity.ProductCategory;
import com.cloud.product.entity.ProductInfo;
import com.cloud.product.repository.ProductCategoryRepository;
import com.cloud.product.repository.ProductInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 8:38
 */
@Service
@Slf4j
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

	@Override
	@Transactional
	public List<ProductDetailVo> reduceProduct(List<ProductDetailDto> productDetailDtoList) throws Exception {
		//根据产品ID校验产品是否存在，是否足够扣库存
		List<ProductDetailVo> detailVoList = new ArrayList<>();
		productDetailDtoList.forEach(p -> {
			Optional<ProductInfo> productInfo = productInfoRepository.findById(p.getProductId());
			if(!productInfo.isPresent()){
				throw new RuntimeException("产品："+p.getProductId()+"不存在");
			}
			if(productInfo.get().getProductStock()-p.getCount()<0){
				throw new RuntimeException("产品："+p.getProductId()+"库存不足");
			}
			//TODO为了调试 去除产品状态校验
			productInfo.get().setProductStock(productInfo.get().getProductStock()-p.getCount());
			productInfoRepository.save(productInfo.get());
			ProductDetailVo productDetailVo = new ProductDetailVo();
			BeanUtils.copyProperties(productInfo.get(),productDetailVo);
			productDetailVo.setCount(p.getCount());
			detailVoList.add(productDetailVo);
		});
		return detailVoList;
	}
}
