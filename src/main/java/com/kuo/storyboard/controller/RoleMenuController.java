package com.kuo.storyboard.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kuo.storyboard.service.IRoleMenuService;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:53
 * @describe System Role Menus
 */
@RestController
public class RoleMenuController {

    @Resource
    private IRoleMenuService roleMenuService;
}