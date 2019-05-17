package com.cloud.product.utils;

import com.cloud.product.vo.ResultVo;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 9:13
 */
public class ResultVoUtil {
	/**
	 * 请求成功
	 * @param object
	 * @return
	 */
	public static ResultVo success(Object object) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(0);
		resultVo.setMsg("成功");
		resultVo.setData(object);
		return resultVo;
	}
}
