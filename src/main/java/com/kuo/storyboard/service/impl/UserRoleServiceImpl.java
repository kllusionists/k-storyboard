package com.kuo.storyboard.service.impl;

import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.entity.UserRole;
import com.kuo.storyboard.mapper.UserRoleMapper;
import com.kuo.storyboard.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:55:43
 * @describe System User Roles服务实现类
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;
}
