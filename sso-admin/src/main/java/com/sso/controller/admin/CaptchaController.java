
package com.sso.controller.admin;

import com.sso.common.model.result.ResultModel;
import com.sso.service.admin.CaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 验证码操作处理
 *
 * @author 聂建强
 */
@Slf4j
@RestController
public class CaptchaController {

	@Autowired
	private CaptchaService captchaService;

	/**
	 * 生成验证码
	 */
	@RequestMapping("/captchaImage")
	public ResultModel<?> getCode(HttpServletResponse response) {
		return ResultModel.success(captchaService.genCode(response));
	}
}
