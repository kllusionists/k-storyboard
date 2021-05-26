package com.kuo.storyboard.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2020/12/17
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

	@Value("${oauth2-server}")
	private String oauth2Server;

	@Resource
	private TokenStore jwtTokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jwtTokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		String[] ignoresUri = new String[] {
				"/**/*swagger*/**",
				"/v2/api-docs",
				"/oauth/token",
				"/oauth/token_key",
				"/oauth/check_token",
				"/auth/login",
				"/auth/token/refresh",
				"/auth/token/authorize",
				"/auth/token/authorize/login",
				"/attachments/**"
		};
		http.logout().logoutSuccessUrl(oauth2Server + "/auth/logout").and()
				.authorizeRequests()
				.antMatchers(ignoresUri)
				.permitAll()
				.and()
				.authorizeRequests().anyRequest().authenticated();
	}
}
