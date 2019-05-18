package com.cloud.product.utils;

import com.cloud.poruct.vo.ResultVo;
import com.cloud.product.enums.Error;
import org.apache.commons.lang.enums.Enum;

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

	public static ResultVo error(Error error, String message) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(error.getCode());
		resultVo.setMsg(message);
		resultVo.setData(null);
		return resultVo;
	}
}
