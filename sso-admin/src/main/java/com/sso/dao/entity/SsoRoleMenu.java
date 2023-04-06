
package com.sso.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 角色和菜单关系实体类
 *
 * @author 聂建强
 */
@Data
public class SsoRoleMenu implements Serializable {

	private static final long serialVersionUID = -8633658293267783613L;

	/**
	 * 系统编码
	 */
	private String sysCode;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 菜单ID
	 */
	private Long menuId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;


}
