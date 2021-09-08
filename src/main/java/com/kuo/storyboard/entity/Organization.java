package com.kuo.storyboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:53:10
 * @describe System organization tree
 */
@Data
@TableName("sys_organization")
public class Organization {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_organization_id", type = IdType.AUTO)
    private Long sysOrganizationId;

	@TableField("parent_organization_id")
    private Long parentOrganizationId;

	@TableField("organization_name")
    private String organizationName;

	@TableField("sort")
    private Integer sort;

	@TableField("disabled")
    private Boolean disabled;

	@TableField("created_by")
    private Long createdBy;

	@TableField("updated_by")
    private Long updatedBy;

	@TableField("created_on")
    private Date createdOn;

	@TableField("updated_on")
    private Date updatedOn;

}