package com.kuo.storyboard.service;

import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.dto.UserDetailsDto;
import com.kuo.storyboard.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Channing Kuo
 * @date 2021-05-21 15:42:09
 * @describe System UsersService类
 */
public interface ISystemUserService extends IService<SystemUser> {

	/**
	 * 获取用户详细信息
	 * @param username 用户名
	 * @return UserDetailsDto
	 * @throws ServiceException Exception
	 */
	UserDetailsDto userDetails(String username) throws ServiceException;
}
