package com.kuo.storyboard.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kuo.storyboard.service.IOrganizationService;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:10
 * @describe System organization tree
 */
@RestController
public class OrganizationController {

    @Resource
    private IOrganizationService organizationService;
}