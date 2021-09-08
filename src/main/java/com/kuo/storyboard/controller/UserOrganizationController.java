package com.kuo.storyboard.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kuo.storyboard.service.IUserOrganizationService;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:55:16
 * @describe System User Organizations
 */
@RestController
public class UserOrganizationController {

    @Resource
    private IUserOrganizationService userOrganizationService;
}