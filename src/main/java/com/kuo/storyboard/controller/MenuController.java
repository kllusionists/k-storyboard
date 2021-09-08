package com.kuo.storyboard.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kuo.storyboard.service.IMenuService;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:52:29
 * @describe System menus
 */
@RestController
public class MenuController {

    @Resource
    private IMenuService menuService;
}