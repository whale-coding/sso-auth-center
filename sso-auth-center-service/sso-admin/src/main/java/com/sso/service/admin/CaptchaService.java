
package com.sso.service.admin;

import com.sso.model.vo.captcha.CaptchaVO;

import javax.servlet.http.HttpServletResponse;

/**
 * 验证码接口
 *
 * @author 聂建强
 */
public interface CaptchaService {

	/**
	 * 生成验证码
	 *
	 * @param response
	 */
	CaptchaVO genCode(HttpServletResponse response);
}
