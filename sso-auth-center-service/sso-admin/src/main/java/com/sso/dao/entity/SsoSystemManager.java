
package com.sso.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台管理员关系实体类
 *
 * @author 聂建强
 */
@Data
public class SsoSystemManager implements Serializable {

	private static final long serialVersionUID = 8221382605127103730L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 系统编码
	 */
	private String sysCode;

	/**
	 * 状态 0-启用;1-停用
	 */
	private Integer status;

	/**
	 * 删除标志 0-正常;1-删除
	 */
	private Integer delFlag;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 最后修改者
	 */
	private String updateBy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;


}
