package com.guojh.project.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.util.DigestUtils;
/**
 * 
 * @author 李老湿
 * @date 2017年5月2日
 */
public class MD5Util {
	/**
	 * spring 工具类 MD5加密
	 * 
	 */
	public static String md5(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes());
	}

	/**
	 * shiroMD5+散列
	 * 时间：2016-8-21
	 */
	public static Md5Hash shiromd5(String password,String salt) {
		return new Md5Hash(password,salt, 2);
	}
	public static void main(String[] args) {
//		System.out.println(jdkMD("123456"));
		//e10adc3949ba59abbe56e057f20f883e
		String hash = shiromd5("123123","ASDF").toHex();
		System.out.println(hash);
		
	}
	
	/**
	 * JDK Md5加密
	 */
	public static String jdkMD(String target){
		StringBuilder stringBuilder = new  StringBuilder();
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digest2 = digest.digest(target.getBytes());
		for (byte b : digest2) {
			int l = b & 0xff;
			if(l<16){
				stringBuilder.append("0");
			}
			stringBuilder.append(Integer.toHexString(l));
		}
		return stringBuilder.toString();
	}
	/**
	 * 给用户密码加盐，增加安全性
	 */
	public static String getSalt(int count) {
		// 生成随机字符
		char[] str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		// 随机数
		Random random = new Random();
		/**
		 * StringBuilder 线程不安全 效率高 常用 StringBuffer 线程安全 效率低
		 */
		String salt = "";
		for (int i = 0; i < count; i++) {
			salt += str[random.nextInt(str.length)];
		}
		return salt;
	}

}
