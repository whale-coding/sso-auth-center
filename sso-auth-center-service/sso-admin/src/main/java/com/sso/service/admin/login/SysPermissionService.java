
package com.sso.service.admin.login;

import com.sso.common.constant.SsoConstants;
import com.sso.common.constant.SsoPermissionConstants;
import com.sso.common.enums.MenuTypeEnum;
import com.sso.common.model.login.LoginResultVO;
import com.sso.common.model.login.LoginUserVO;
import com.sso.common.utils.ServletUtils;
import com.sso.common.utils.StringUtils;
import com.sso.common.utils.bean.BeanCopierUtil;
import com.sso.common.utils.tree.ListToTreeUtil;
import com.sso.dao.entity.SsoMenu;
import com.sso.mapper.SsoMenuMapper;
import com.sso.mapper.SsoRoleMapper;
import com.sso.common.config.property.SysConfigProperty;
import com.sso.model.vo.login.LoginMenuVO;
import com.sso.model.vo.login.LoginUserInfoVO;
import com.sso.service.base.SsoTokenService;
import com.sso.service.base.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户权限处理
 *
 * @author 聂建强
 */
@Component
public class SysPermissionService {

	@Autowired
	private SsoTokenService ssoTokenService;
	@Resource
	private SsoMenuMapper ssoMenuMapper;
	@Resource
	private SsoRoleMapper ssoRoleMapper;
	@Resource
	private SysConfigProperty sysConfigProperty;
	@Resource
	private SysConfigService sysConfigService;

	/**
	 * 获取登录用户信息
	 *
	 * @return
	 */
	public LoginUserInfoVO getLoginUserInfo() {
		// 获取当前登录用户
		LoginResultVO loginResultVO = ssoTokenService.getLoginUser(ServletUtils.getRequest());
		LoginUserVO user = loginResultVO.getUser();
		user.setPassword("");

		//菜单权限
		LoginUserInfoVO userInfo = this.getMenuPermission(user);
		//用户信息
		userInfo.setUser(user);
		//角色Key
		userInfo.setRoleKeyList(this.getRolePermission(user));
		return userInfo;
	}

	/**
	 * 获取角色数据权限
	 *
	 * @param user 用户信息
	 * @return 角色权限信息
	 */
	public Set<String> getRolePermission(LoginUserVO user) {
		Set<String> roles = new HashSet<>();
		// 管理员拥有所有权限
		if (sysConfigService.getSupperAdminUserId().equals(user.getUserId())) {
			roles.add("**");
		} else {
			roles.addAll(ssoRoleMapper.getRoleKeyBySysCodeAndUserId(sysConfigProperty.getAuthSsoSysCode(), user.getUserId()));
		}
		return roles;
	}

	/**
	 * 获取菜单数据权限
	 *
	 * @param user 用户信息
	 * @return 菜单权限信息
	 */
	public LoginUserInfoVO getMenuPermission(LoginUserVO user) {
		return this.getMenuPermissionByUser(sysConfigProperty.getAuthSsoSysCode(), user);
	}

	public LoginUserInfoVO getMenuPermissionByUser(String sysCode, LoginUserVO user) {
		Set<String> permissionList;
		List<SsoMenu> menuList;

		//管理员拥有所有权限
		if (sysConfigService.getSupperAdminUserId().equals(user.getUserId())) {
			permissionList = Collections.singleton(SsoPermissionConstants.ALL_PERMISSION);
			menuList = ssoMenuMapper.getEnableMenuListBySysCode(sysCode);
			//转换成树结构
			List<LoginMenuVO> treeNodeVOList = BeanCopierUtil.copyList(menuList, LoginMenuVO.class);
			ListToTreeUtil<LoginMenuVO> result = new ListToTreeUtil<>();
			return new LoginUserInfoVO(permissionList, result.getTreeListObject(treeNodeVOList));
		}

		//非管理员-根据角色查询权限
		menuList = ssoMenuMapper.getMenuListBySysCodeAndUserId(sysCode, user.getUserId());
		if (CollectionUtils.isEmpty(menuList)) {
			return LoginUserInfoVO.initDefault();
		}

		LoginMenuVO menuVO = null;
		List<LoginMenuVO> menuResList = new ArrayList<>(menuList.size());
		//权限标识集
		permissionList = new HashSet<>(menuList.size());
		for (SsoMenu menu : menuList) {
			if (StringUtils.isNotBlank(menu.getPermissions())) {
				permissionList.addAll(Arrays.asList(menu.getPermissions().split(SsoConstants.SPLIT_ESCAPE)));
			}
			//菜单
			if (MenuTypeEnum.isMenu(menu.getMenuType())) {
				menuVO = BeanCopierUtil.copy(menu, LoginMenuVO.class);
				menuResList.add(menuVO);
			}
		}
		//菜单转换成树结构
		List<LoginMenuVO> treeNodeVOList = BeanCopierUtil.copyList(menuResList, LoginMenuVO.class);
		ListToTreeUtil<LoginMenuVO> result = new ListToTreeUtil<>();
		return new LoginUserInfoVO(permissionList, result.getTreeListObject(treeNodeVOList));
	}


}
