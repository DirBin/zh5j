package com.zh5j.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh5j.common.exception.IllegalParameterException;
import com.zh5j.common.util.WebUtil;
import com.zh5j.sys.api.ISysAuthorizeProvider;
import com.zh5j.sys.entity.SysMenu;
import com.zh5j.sys.entity.SysRoleMenu;
import com.zh5j.sys.entity.SysUserMenu;
import com.zh5j.sys.entity.SysUserRole;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:00
 */
@Service
public class SysAuthorizeService {
	@Autowired
	private ISysAuthorizeProvider sysAuthorizeProvider;

	public List<SysMenu> queryAuthorizeByUserId(Long id) {
		return sysAuthorizeProvider.queryAuthorizeByUserId(id);
	}

	public List<String> queryMenuIdsByUserId(Long userId) {
		return sysAuthorizeProvider.queryMenuIdsByUserId(userId);
	}

	public List<String> queryMenuIdsByRoleId(Long roleId) {
		return sysAuthorizeProvider.queryMenuIdsByRoleId(roleId);
	}

	public List<SysUserRole> getRolesByUserId(Long userId) {
		return sysAuthorizeProvider.getRolesByUserId(userId);
	}

	public void updateUserMenu(List<SysUserMenu> sysUserMenus) {
		Long userId = null;
		Long currentUserId = WebUtil.getCurrentUser();
		for (SysUserMenu sysUserMenu : sysUserMenus) {
			if (sysUserMenu.getUserId() != null) {
				if (userId != null && userId != sysUserMenu.getUserId()) {
					throw new IllegalParameterException("参数错误.");
				}
				userId = sysUserMenu.getUserId();
			}
			sysUserMenu.setCreateBy(currentUserId);
			sysUserMenu.setUpdateBy(currentUserId);
		}
		sysAuthorizeProvider.updateUserMenu(sysUserMenus);
	}

	public void updateUserRole(List<SysUserRole> sysUserRoles) {
		Long userId = null;
		Long currentUserId = WebUtil.getCurrentUser();
		for (SysUserRole sysUserRole : sysUserRoles) {
			if (sysUserRole.getUserId() != null) {
				if (userId != null && userId != sysUserRole.getUserId()) {
					throw new IllegalParameterException("参数错误.");
				}
				userId = sysUserRole.getUserId();
			}
			sysUserRole.setCreateBy(currentUserId);
			sysUserRole.setUpdateBy(currentUserId);
		}
		sysAuthorizeProvider.updateUserRole(sysUserRoles);
	}

	public void updateRoleMenu(List<SysRoleMenu> sysRoleMenus) {
		Long roleId = null;
		Long userId = WebUtil.getCurrentUser();
		for (SysRoleMenu sysRoleMenu : sysRoleMenus) {
			if (sysRoleMenu.getRoleId() != null) {
				if (roleId != null && roleId != sysRoleMenu.getRoleId()) {
					throw new IllegalParameterException("参数错误.");
				}
				roleId = sysRoleMenu.getRoleId();
			}
			sysRoleMenu.setCreateBy(userId);
			sysRoleMenu.setUpdateBy(userId);
		}
		sysAuthorizeProvider.updateRoleMenu(sysRoleMenus);
	}

	public List<SysMenu> queryMenusPermission() {
		return sysAuthorizeProvider.queryMenusPermission();
	}

	public void updateUserPermission(List<SysUserMenu> sysUserMenus) {
		sysAuthorizeProvider.updateUserPermission(sysUserMenus);
	}

	public void updateRolePermission(List<SysRoleMenu> sysRoleMenus) {
		sysAuthorizeProvider.updateRolePermission(sysRoleMenus);
	}

	/** 获取用户权限 */
	public List<String> queryPermissionByUserId(Long userId) {
		return sysAuthorizeProvider.queryPermissionByUserId(userId);
	}

	public List<Map<String, Object>> queryUserPermissions(SysUserMenu record) {
		return sysAuthorizeProvider.queryUserPermissions(record);
	}

	public List<Map<String, Object>> queryRolePermissions(SysRoleMenu record) {
		return sysAuthorizeProvider.queryRolePermissions(record);
	}
}
