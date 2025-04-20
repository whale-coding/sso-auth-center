
package com.sso.controller.admin;


import com.sso.common.model.login.LoginUserVO;
import com.sso.common.model.result.ResultModel;
import com.sso.common.utils.SecurityUtils;
import com.sso.model.bo.user.UserUpdateProfileBO;
import com.sso.model.bo.user.UserUpdatePwdBO;
import com.sso.model.vo.user.UserProfileVO;
import com.sso.service.admin.FileUploadService;
import com.sso.service.admin.UserService;
import com.sso.utils.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.UUID;

/**
 * 用户-个人详情接口
 *
 * @author 聂建强
 */
@Slf4j
@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

	@Autowired
	private UserService userService;

	@Resource
	private FileUploadService fileUploadService;

	@Resource
	private AliyunOSSUtils aliyunOSSUtils;

	/**
	 * 个人详情
	 */
	@RequestMapping("/detail")
	public ResultModel<UserProfileVO> getUserProfile() {
		LoginUserVO loginUser = SecurityUtils.getLoginUser();
		return ResultModel.success(userService.getUserProfile(loginUser.getUserId()));
	}

	/**
	 * 修改个人信息
	 *
	 * @param updateBO
	 */
	@PutMapping("/update")
	public ResultModel<?> updateProfile(@Valid @RequestBody UserUpdateProfileBO updateBO) {
		updateBO.setOperateBy(SecurityUtils.getOperateName());
		userService.updateProfile(updateBO);
		return ResultModel.success();
	}

	/**
	 * 修改个人密码
	 *
	 * @param updateBO
	 */
	@PutMapping("/updatePwd")
	public ResultModel<?> updatePwd(@Valid @RequestBody UserUpdatePwdBO updateBO) {
		updateBO.setOperateBy(SecurityUtils.getOperateName());
		userService.updatePwd(updateBO);
		return ResultModel.success();
	}

	/**
	 * 个人-头像上传
	 */
	@PostMapping("/avatar")
	public ResultModel<?> avatar(@RequestParam("avatarFile") MultipartFile avatarFile) throws Exception{
		if (!avatarFile.isEmpty()){
			// 获取当前登录用户
			LoginUserVO loginUser = SecurityUtils.getLoginUser();
			// 获得原始文件名
			String originalFilename = avatarFile.getOriginalFilename();
			// 获取图片类型
			String contentType = avatarFile.getContentType();
			//唯一的文件名称(避免同名文件覆盖问题)
			String filename = UUID.randomUUID().toString() + "." + org.apache.commons.lang3.StringUtils.substringAfterLast(originalFilename, ".");
			// 上传到阿里云OSS
			String avatar = aliyunOSSUtils.uploadImage(filename, avatarFile.getBytes(), contentType, 1000);
			// 上传成功则返回图片地址platformMgmt
			if (userService.updateUserAvatar(loginUser.getUsername(), avatar)) {
				return ResultModel.success(avatar);
			}

		}
		return ResultModel.error("上传图片异常，请联系管理员");
	}

}
