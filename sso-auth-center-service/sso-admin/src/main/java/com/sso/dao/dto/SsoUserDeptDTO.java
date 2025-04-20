
package com.sso.dao.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门实体类
 *
 * @author 聂建强
 */
@Data
public class SsoUserDeptDTO implements Serializable {

	private static final long serialVersionUID = -2778006438843424841L;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 部门名称
	 */
	private String deptName;

}
