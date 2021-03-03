package com.website.app.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.website.common.util.cache.RedisUtils;
import com.website.mybatis.bean.auto.system.CMUser;

/**
 * 
 * app安全工具类
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 * @see 下午12:21:46
 */
public class SecretUtil {

	private static String letter = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";

	/**
	 * 
	 * 根据输入长度获取随机码
	 * 
	 * @author renxingchen
	 * @param length
	 * @return
	 */
	public static String getRandomCode(int length) {
		String[] sourceCode = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
				"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
				"Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };
		List<String> list = Arrays.asList(sourceCode);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(0, length);
		return result;
	}

	/**
	 * 
	 * 生成token码
	 * 
	 * 生成规则： uuid + 三位随机字母 + 三位随机数
	 * 
	 * @author renxingchen
	 * @return
	 */
	public static String createToken(CMUser user, String encrypt) {
		String token = UUID.randomUUID().toString();
		Random random = new Random();
		// 生成随机三位字母
		for (int i = 0; i < 3; i++) {
			token = token + letter.charAt(random.nextInt(52));
		}
		// 生成一个随机的三位数
		token = token + getRandomNum(1000);
		// 生成token值并存储
		TokenValue tokenValue = new TokenValue(user, encrypt);
		// 写入redis缓存，key为token，value为tokenValue
		RedisUtils.set(token, JSON.toJSONString(tokenValue), 7 * 86400);
		return token;
	}

	/**
	 * 
	 * 根据token获取缓存中的用户信息
	 * 
	 * @author renxingchen
	 * @param token
	 * @return
	 */
	public static CMUser getTokenUser(String token) {
		String tokenValue = RedisUtils.get(token);
		CMUser user = null;
		if (StringUtils.isNotBlank(tokenValue)) {
			// 获取缓存中token的值
			TokenValue value = JSON.parseObject(tokenValue, TokenValue.class);
			user = value.getUserInfo();
		}
		return user;
	}

	/**
	 * 
	 * 获取用户私有秘钥
	 * 
	 * @author renxingchen
	 * @param token
	 * @return
	 */
	public static String getEncrypt(String token) {
		String tokenValue = RedisUtils.get(token);
		String enctypt = "";
		if (StringUtils.isNotBlank(tokenValue)) {
			// 获取缓存中token的值
			TokenValue value = JSON.parseObject(tokenValue, TokenValue.class);
			enctypt = value.getEncrypt();
		}
		return enctypt;
	}

	/**
	 * 
	 * 根据tmp返回指定位数的随机整数
	 * 
	 * @author renxingchen
	 * @param tmp
	 *            100，1000，10000
	 * @return
	 */
	public static int getRandomNum(int tmp) {
		int randomNum = 0;
		while (randomNum < (tmp / 10)) {
			randomNum = (int) (Math.random() * tmp);
		}
		return randomNum;
	}

}
