
package com.sso.dao.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色
 *
 * @author 聂建强
 */
@Data
public class SsoUserRoleDTO implements Serializable {

	private static final long serialVersionUID = 219537171519448483L;
	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 角色id多个逗号分隔
	 */
	private String roleIds;

	/**
	 * 角色名称多个逗号分隔
	 */
	private String roleNames;

}
