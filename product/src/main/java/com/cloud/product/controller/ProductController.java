package com.cloud.product.controller;

import com.cloud.product.service.ProductService;
import com.cloud.product.utils.ResultVoUtil;
import com.cloud.product.vo.ProductResultVo;
import com.cloud.product.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
