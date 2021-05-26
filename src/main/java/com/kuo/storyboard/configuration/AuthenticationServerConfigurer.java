package com.kuo.storyboard.configuration;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author Channing Kuo
 * @date 2020/12/16
 */
@Configuration
@EnableAuthorizationServer
public class AuthenticationServerConfigurer extends AuthorizationServerConfigurerAdapter {

	@Resource
	public UserDetailsService userDetailsService;

	@Resource
	private AuthenticationManager authenticationManager;

	@Resource
	private TokenStore jwtTokenStore;

	@Resource
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Resource
	private TokenEnhancer jwtTokenEnhancer;

	@Resource
	private DataSource dataSource;

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();

		List<TokenEnhancer> enhancerList = Lists.newArrayList();
		enhancerList.add(jwtTokenEnhancer);
		enhancerList.add(jwtAccessTokenConverter);

		enhancerChain.setTokenEnhancers(enhancerList);

		endpoints.tokenStore(jwtTokenStore)
				.userDetailsService(userDetailsService)
				.authenticationManager(authenticationManager)
				.tokenEnhancer(enhancerChain)
				.accessTokenConverter(jwtAccessTokenConverter);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(new JdbcClientDetailsService(dataSource));
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients();
		security.checkTokenAccess("isAuthenticated()");
		security.tokenKeyAccess("isAuthenticated()");
	}
}
