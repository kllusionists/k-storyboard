package com.kuo.storyboard.dto;

import lombok.Data;

/**
 * @author Channing Kuo
 * @date 2021/9/7
 */
@Data
public class AuthenticationDto {
	private String appId;
	private String appKey;
	private String userName;
	private String password;
	private String code;
	private String redirectUri;
	private String accessToken;
	private String refreshToken;
}
