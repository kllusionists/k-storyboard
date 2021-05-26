package com.kuo.storyboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author Channing Kuo
 * @date 2021-05-21 15:42:09
 * @describe System Users
 */
@Data
@TableName("sys_user")
public class SystemUser {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_user_id", type = IdType.AUTO)
    private Long sysUserId;

	@TableField("sys_user_no")
    private String sysUserNo;

	@TableField("user_account")
    private String userAccount;

	@TableField("user_password")
    private String userPassword;

	@TableField("cell_phone")
    private String cellPhone;

	@TableField("user_name")
    private String userName;

	@TableField("user_email")
    private String userEmail;

	@TableField("user_active")
    private Boolean userActive;

	@TableField("user_deleted")
    private Boolean userDeleted;

	@TableField("created_by")
    private Long createdBy;

	@TableField("updated_by")
    private Long updatedBy;

	@TableField("created_on")
    private Date createdOn;

	@TableField("updated_on")
    private Date updatedOn;

}