package com.sso.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户与目标系统关系实体类
 *
 * @author 聂建强
 */
@Data
public class SsoUserSystem implements Serializable {

	private static final long serialVersionUID = -6154959745933571133L;

	/**
	 * 自增ID
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
	 * 显示顺序
	 */
	private Integer sortNum;

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
