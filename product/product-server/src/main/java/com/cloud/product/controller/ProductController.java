package com.cloud.product.controller;

import com.cloud.poruct.dto.ProductDetailDto;
import com.cloud.poruct.vo.ProductDetailVo;
import com.cloud.poruct.vo.ProductResultVo;
import com.cloud.poruct.vo.ResultVo;
import com.cloud.product.enums.Error;
import com.cloud.product.service.ProductService;
import com.cloud.product.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 9:10
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public ResultVo<ProductResultVo> list(){
		List<ProductResultVo> resultVoList = productService.listAll();
		return ResultVoUtil.success(resultVoList);
	}

	@RequestMapping("/reduceProduct")
	public ResultVo<List<ProductDetailVo>> reduceProduct(@RequestBody @Valid List<ProductDetailDto> productDetailDtoList, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return ResultVoUtil.error(Error.PARM_ERROR,bindingResult.getFieldError().getDefaultMessage());
		}
		List<ProductDetailVo> productDetailVoList = null;
		try {
			productDetailVoList =  productService.reduceProduct(productDetailDtoList);
		}catch (Exception e){
			return ResultVoUtil.error(Error.BUSINESS_ERROR,e.getMessage());
		}
		return ResultVoUtil.success(productDetailVoList);
	}

	@GetMapping("/getMsg")
	public String getProductMsg(){
		return  "mgs";
	}
}
