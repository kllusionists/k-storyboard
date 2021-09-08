package com.kuo.storyboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author Channing Kuo
 * @date 2021-09-07 16:52:29
 * @describe System menus
 */
@Data
@TableName("sys_menu")
public class Menu {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_menu_id", type = IdType.AUTO)
    private Long sysMenuId;

	@TableField("parent_menu_id")
    private Long parentMenuId;

	@TableField("menu_title")
    private String menuTitle;

	@TableField("menu_name")
    private String menuName;

	@TableField("file_path")
    private String filePath;

	@TableField("menu_seq")
    private Integer menuSeq;

	@TableField("menu_icon")
    private String menuIcon;

	@TableField("router_path")
    private String routerPath;

	@TableField("hidden")
    private Boolean hidden;

	@TableField("outer_path")
    private Boolean outerPath;

	@TableField("redirect_path")
    private String redirectPath;

	@TableField("auto_refresh")
    private Boolean autoRefresh;

	@TableField("menu_params")
    private String menuParams;

	@TableField("created_by")
    private Long createdBy;

	@TableField("updated_by")
    private Long updatedBy;

	@TableField("created_on")
    private Date createdOn;

	@TableField("updated_on")
    private Date updatedOn;

}