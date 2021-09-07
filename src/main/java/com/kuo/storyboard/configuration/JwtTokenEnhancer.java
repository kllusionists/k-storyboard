package com.kuo.storyboard.configuration;

import com.google.common.collect.Maps;
import com.kuo.storyboard.dto.UserDetailsDto;
import com.kuo.storyboard.service.ISystemUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Channing Kuo
 * @date 2020/12/17
 */
public class JwtTokenEnhancer implements TokenEnhancer {

	@Resource
	private ISystemUserService systemUserService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
		User principal = (User) oAuth2Authentication.getPrincipal();
		String userName = principal.getUsername();

		UserDetailsDto userDetailsDto = systemUserService.userDetails(userName);

		Map<String, Object> info = Maps.newHashMap();
		info.put("real_name", userDetailsDto.getRealName());

//		info.put("user_name", userDetailsDto.getUserName());

//		info.put("avatar", userDetailsDto.getAvatarUrl());

		info.put("cellphone", userDetailsDto.getCellPhone());
		info.put("user_id", userDetailsDto.getUserId());
		info.put("email", userDetailsDto.getEmail());

		((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
		return oAuth2AccessToken;
	}
}
