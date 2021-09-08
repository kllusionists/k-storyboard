package com.kuo.storyboard.service.impl;

import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.entity.Role;
import com.kuo.storyboard.mapper.RoleMapper;
import com.kuo.storyboard.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:27
 * @describe System Roles服务实现类
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;
}
