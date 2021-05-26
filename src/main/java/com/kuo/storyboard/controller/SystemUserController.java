package com.kuo.storyboard.controller;

import com.kuo.storyboard.core.Result;
import com.kuo.storyboard.core.ResultGenerator;
import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.service.ISystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-05-21 15:42:09
 * @describe System Users
 */
@Api(value = "/user", tags = "用户管理模块")
@RestController
@RequestMapping("/user")
public class SystemUserController {

    @Resource
    private ISystemUserService systemUserService;

    @ApiOperation(value = "测试", notes = "测试")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Result<?> test() {
        try {
            return ResultGenerator.genSuccessResult("hello");
        } catch (ServiceException e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
}