package com.kuo.storyboard.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Channing Kuo
 * @date 2021/9/7
 */
public class ClientEncoderUtils {

	private static BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

	private static String bcryptEncode(String password) {
		return bcryptEncoder.encode(password);
	}

	private static String genOauthEncodePwd(String password) {
		return  bcryptEncode(password);
	}

	public static void main(String[] args) {
		// String oriPwd = "storyboard-kuo-client-secret";
		String oriPwd = "190a4568b24548e0dc8592f61f0a8cd2";
		System.out.println(genOauthEncodePwd(oriPwd));
	}
}
