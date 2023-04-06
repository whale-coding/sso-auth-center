
package com.sso.service.admin;

import com.sso.common.model.result.ResultPageModel;
import com.sso.model.bo.login.LoginLogListPageBO;
import com.sso.model.vo.login.LoginLogPageVO;

/**
 * 登录日志接口
 *
 * @author 聂建强
 */
public interface LoginLogService {

	/**
	 * 登录日志分页列表
	 *
	 * @param pageBO
	 * @return 登录日志列表
	 */
	ResultPageModel<LoginLogPageVO> listPageUser(LoginLogListPageBO pageBO);

}
