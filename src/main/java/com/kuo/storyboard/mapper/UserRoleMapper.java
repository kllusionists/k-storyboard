package com.kuo.storyboard.mapper;

import com.kuo.storyboard.dto.UserDetailsDto;
import com.kuo.storyboard.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:55:43
 * @describe System User RolesMapper类
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

	/**
	 * 用户详细信息
	 * @param username 用户名(account)
	 * @return UserDetailsDto
	 */
	UserDetailsDto getSystemUserInfo(String username);
}