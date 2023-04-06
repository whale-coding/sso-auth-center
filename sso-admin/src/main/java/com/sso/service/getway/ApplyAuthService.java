
package com.sso.service.getway;

import com.sso.common.annotation.OpenApi;
import com.sso.model.bo.getway.ApplyAuthBO;
import com.sso.model.vo.getway.ApplyAuthVO;

/**
 * 申请认证开放接口
 *
 * @author 聂建强
 */
public interface ApplyAuthService {

	/**
	 * 申请认证开放接口
	 *
	 * @param authBO
	 */
	@OpenApi(method = "com.sso.applyAuth", desc = "申请认证")
	ApplyAuthVO applyAuth(String sysCode, ApplyAuthBO authBO);
}
