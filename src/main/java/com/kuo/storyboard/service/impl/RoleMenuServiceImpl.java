package com.kuo.storyboard.service.impl;

import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.entity.RoleMenu;
import com.kuo.storyboard.mapper.RoleMenuMapper;
import com.kuo.storyboard.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:53
 * @describe System Role Menus服务实现类
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;
}
