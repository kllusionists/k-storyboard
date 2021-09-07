package com.kuo.storyboard.configuration;

import com.google.common.collect.Lists;
import com.kuo.storyboard.dto.UserDetailsDto;
import com.kuo.storyboard.service.ISystemUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Channing Kuo
 * @date 2020/12/16
 */
@Slf4j
@Component(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource
	private ISystemUserService systemUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("user [{}] is accessing Oauth Server.", username);
		UserDetailsDto userDetailsDto = systemUserService.userDetails(username);

		List<SimpleGrantedAuthority> authorities = Lists.newArrayList();
		userDetailsDto.getUserRoleList().forEach(userRole -> {
			authorities.add(new SimpleGrantedAuthority(userRole.getRoleValue()));
		});
		return new User(username, userDetailsDto.getPassword(), authorities);
	}
}
