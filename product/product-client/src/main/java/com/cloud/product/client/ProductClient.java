package com.cloud.product.client;

import com.cloud.poruct.dto.ProductDetailDto;
import com.cloud.poruct.vo.ProductDetailVo;
import com.cloud.poruct.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/17 10:57
 */
@FeignClient(name = "product")
public interface ProductClient {

	@GetMapping("/product/getMsg")
	String getProductMsg();

	@RequestMapping("/product/reduceProduct")
	public ResultVo<List<ProductDetailVo>> reduceProduct(@RequestBody List<ProductDetailDto> productDetailDtoList);

}
