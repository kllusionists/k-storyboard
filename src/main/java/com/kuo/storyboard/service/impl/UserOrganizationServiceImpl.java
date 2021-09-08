package com.kuo.storyboard.service.impl;

import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.entity.UserOrganization;
import com.kuo.storyboard.mapper.UserOrganizationMapper;
import com.kuo.storyboard.service.IUserOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:55:16
 * @describe System User Organizations服务实现类
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserOrganizationServiceImpl extends ServiceImpl<UserOrganizationMapper, UserOrganization> implements IUserOrganizationService {

    @Resource
    private UserOrganizationMapper userOrganizationMapper;
}
