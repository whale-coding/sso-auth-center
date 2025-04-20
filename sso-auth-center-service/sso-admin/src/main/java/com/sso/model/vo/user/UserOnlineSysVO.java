
package com.sso.model.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录日志实体类
 *
 * @author 聂建强
 */
@Data
public class UserOnlineSysVO implements Serializable {

	private static final long serialVersionUID = -3040345372070636603L;

	/**
	 * 系统编码
	 */
	private String sysCode;

	/**
	 * 系统名称
	 */
	private String sysName;

	/**
	 * 登录时间
	 */
	private String loginTime;

}
