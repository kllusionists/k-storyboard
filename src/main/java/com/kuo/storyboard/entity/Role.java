package com.kuo.storyboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:27
 * @describe System Roles
 */
@Data
@TableName("sys_role")
public class Role {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_role_id", type = IdType.AUTO)
    private Long sysRoleId;

	@TableField("role_name")
    private String roleName;

	@TableField("role_code")
    private String roleCode;

	@TableField("created_by")
    private Long createdBy;

	@TableField("updated_by")
    private Long updatedBy;

	@TableField("created_on")
    private Date createdOn;

	@TableField("updated_on")
    private Date updatedOn;

}