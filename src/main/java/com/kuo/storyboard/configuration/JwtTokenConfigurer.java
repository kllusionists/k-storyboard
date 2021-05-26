package com.kuo.storyboard.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author Channing Kuo
 * @date 2020/12/17
 */
@Configuration
public class JwtTokenConfigurer {

	@Value("${jwt-key-value}")
	private String signingKey;

	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey(signingKey);
		accessTokenConverter.setVerifierKey(signingKey);
		return accessTokenConverter;
	}

	@Bean
	public TokenEnhancer jwtTokenEnhancer() {
		return new JwtTokenEnhancer();
	}
}
