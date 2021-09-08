package com.kuo.storyboard.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kuo.storyboard.service.IRoleService;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:27
 * @describe System Roles
 */
@RestController
public class RoleController {

    @Resource
    private IRoleService roleService;
}