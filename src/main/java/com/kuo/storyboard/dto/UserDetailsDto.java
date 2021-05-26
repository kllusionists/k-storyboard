package com.kuo.storyboard.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Channing Kuo
 * @date 2021/5/21
 */
@Data
public class UserDetailsDto {
	private Long userId;
	private String cellPhone;
	private String userName;
	private String password;
	private List<RoleDto> userRoleList;
	private String realName;
	private String avatarUrl;
}
