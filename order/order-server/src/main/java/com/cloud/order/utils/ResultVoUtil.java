package com.cloud.order.utils;

import com.cloud.order.vo.ResultVo;

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
	public static ResultVo error(Integer code,String message) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(code);
		resultVo.setMsg(message);
		resultVo.setData(null);
		return resultVo;
	}
}
