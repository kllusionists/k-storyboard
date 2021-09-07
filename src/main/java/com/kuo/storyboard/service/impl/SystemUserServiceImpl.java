package com.kuo.storyboard.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuo.storyboard.core.ErrorEnum;
import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.dto.UserDetailsDto;
import com.kuo.storyboard.entity.SystemUser;
import com.kuo.storyboard.mapper.SystemUserMapper;
import com.kuo.storyboard.mapper.UserRoleMapper;
import com.kuo.storyboard.service.ISystemUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-05-21 15:42:09
 * @describe System Users服务实现类
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetailsDto userDetails(String username) throws ServiceException {
        if (StringUtils.isBlank(username)) {
            throw new ServiceException(ErrorEnum.USERNAME_EMPTY);
        }

        UserDetailsDto result = userRoleMapper.getSystemUserInfo(username);

        if (null == result) {
            throw new ServiceException(ErrorEnum.USERNAME_ERROR);
        }

        return result;
    }
}
