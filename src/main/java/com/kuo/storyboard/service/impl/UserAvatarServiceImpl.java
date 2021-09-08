package com.kuo.storyboard.service.impl;

import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.entity.UserAvatar;
import com.kuo.storyboard.mapper.UserAvatarMapper;
import com.kuo.storyboard.service.IUserAvatarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:54:48
 * @describe System User avatars服务实现类
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserAvatarServiceImpl extends ServiceImpl<UserAvatarMapper, UserAvatar> implements IUserAvatarService {

    @Resource
    private UserAvatarMapper userAvatarMapper;
}
