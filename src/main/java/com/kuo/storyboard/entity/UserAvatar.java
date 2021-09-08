package com.kuo.storyboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:54:48
 * @describe System User avatars
 */
@Data
@TableName("sys_user_avatar")
public class UserAvatar {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_user_avatar_id", type = IdType.AUTO)
    private Long sysUserAvatarId;

	@TableField("sys_user_id")
    private Long sysUserId;

	@TableField("avatar")
    private String avatar;

	@TableField("created_by")
    private Long createdBy;

	@TableField("updated_by")
    private Long updatedBy;

	@TableField("created_on")
    private Date createdOn;

	@TableField("updated_on")
    private Date updatedOn;

}