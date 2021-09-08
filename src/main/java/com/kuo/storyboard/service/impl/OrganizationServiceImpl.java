package com.kuo.storyboard.service.impl;

import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.entity.Organization;
import com.kuo.storyboard.mapper.OrganizationMapper;
import com.kuo.storyboard.service.IOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:10
 * @describe System organization tree服务实现类
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;
}
