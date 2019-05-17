package com.cloud.order.utils;

import java.util.Random;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/15 11:30
 */
public class KeyUtil {
	public static synchronized String genUinqueKey(){
		Random random = new Random();
		Integer number = random.nextInt(900000)+100000;
		return System.currentTimeMillis()+String.valueOf(number);
	}
}
