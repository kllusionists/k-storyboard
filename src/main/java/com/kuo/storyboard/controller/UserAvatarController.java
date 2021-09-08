package com.kuo.storyboard.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kuo.storyboard.service.IUserAvatarService;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:54:48
 * @describe System User avatars
 */
@RestController
public class UserAvatarController {

    @Resource
    private IUserAvatarService userAvatarService;
}