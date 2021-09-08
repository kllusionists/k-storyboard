package com.kuo.storyboard.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kuo.storyboard.service.IUserRoleService;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:55:43
 * @describe System User Roles
 */
@RestController
public class UserRoleController {

    @Resource
    private IUserRoleService userRoleService;
}