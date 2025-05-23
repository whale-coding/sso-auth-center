package com.example.sso.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统配置属性
 *
 * @author 聂建强
 */
@Component
@ConfigurationProperties(prefix = "sys.config")
public class SysConfigProperty {

	/**
	 * 我的系统编码
	 */
	private String mySysCode;

	/**
	 * 认证中心申请认证开放网关地址
	 */
	private String ssoAuthGetWayUrl;

	/**
	 * RSA 加签私钥
	 */
	private String privateKey;

	/**
	 * 本系统退出登录地址
	 */
	private String myLoginOutUrl;

	/**
	 * 认证中心登录地址
	 */
	private static String ssoAuthLoginUrl;

	/**
	 * 当前客户端web地址
	 */
	private static String clientWebUrl;

	public String getMySysCode() {
		return mySysCode;
	}

	public void setMySysCode(String mySysCode) {
		this.mySysCode = mySysCode;
	}

	public String getSsoAuthGetWayUrl() {
		return ssoAuthGetWayUrl;
	}

	public void setSsoAuthGetWayUrl(String ssoAuthGetWayUrl) {
		this.ssoAuthGetWayUrl = ssoAuthGetWayUrl;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public SysConfigProperty setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
		return this;
	}

	public String getMyLoginOutUrl() {
		return myLoginOutUrl;
	}

	public void setMyLoginOutUrl(String myLoginOutUrl) {
		this.myLoginOutUrl = myLoginOutUrl;
	}

	public static String getSsoAuthLoginUrl() {
		return ssoAuthLoginUrl;
	}

	public void setSsoAuthLoginUrl(String ssoAuthLoginUrl) {
		SysConfigProperty.ssoAuthLoginUrl = ssoAuthLoginUrl;
	}

	public static String getClientWebUrl() {
		return clientWebUrl;
	}

	public void setClientWebUrl(String clientWebUrl) {
		SysConfigProperty.clientWebUrl = clientWebUrl;
	}


}
