package com.zh5j.sys.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh5j.common.base.BaseService;
import com.zh5j.common.support.Assert;
import com.zh5j.common.support.login.ThirdPartyUser;
import com.zh5j.common.util.WebUtil;
import com.zh5j.sys.api.ISysUserProvider;
import com.zh5j.sys.entity.SysUser;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:47:21
 */
@Service
public class SysUserService extends BaseService<ISysUserProvider, SysUser> {
	@Autowired
	public void setProvider(ISysUserProvider provider) {
		this.provider = provider;
	}

	/** 修改用户信息 */
	public void updateUserInfo(SysUser sysUser) {
		if (sysUser.getId() != null) {
			SysUser user = this.queryById(sysUser.getId());
			Assert.notNull(user, "USER", sysUser.getId());
			if (StringUtils.isNotBlank(sysUser.getPassword())) {
				if (!sysUser.getPassword().equals(user.getPassword())) {
					sysUser.setPassword(encryptPassword(sysUser.getPassword()));
				}
			}
		}
		update(sysUser);
	}

	/** 修改密码 */
	public void updatePassword(Long id, String oldPassword, String password) {
		Assert.notNull(id, "USER_ID");
		Assert.isNotBlank(oldPassword, "OLDPASSWORD");
		Assert.isNotBlank(password, "PASSWORD");
		SysUser sysUser = provider.queryById(id);
		Assert.notNull(sysUser, "USER", id);
		Long userId = WebUtil.getCurrentUser();
		if (!id.equals(userId)) {
			SysUser user = provider.queryById(userId);
			if ("1".equals(user.getUserType())) {
				throw new UnauthorizedException("您没有权限修改用户密码.");
			}
		} else {
			if (!sysUser.getPassword().equals(encryptPassword(oldPassword))) {
				throw new UnauthorizedException("原密码错误.");
			}
		}
		sysUser.setPassword(encryptPassword(password));
		sysUser.setUpdateBy(WebUtil.getCurrentUser());
		provider.update(sysUser);
	}

	public String encryptPassword(String password) {
		return provider.encryptPassword(password);
	}

	public SysUser thirdPartyLogin(ThirdPartyUser thirdUser) {
		SysUser sysUser = null;
		// 查询是否已经绑定过
		Long userId = provider.queryUserIdByThirdParty(thirdUser.getOpenid(), thirdUser.getProvider());
		if (userId == null) {
			sysUser = insertThirdPartyUser(thirdUser);
		} else {
			sysUser = queryById(userId);
		}
		return sysUser;
	}

	public SysUser insertThirdPartyUser(ThirdPartyUser thirdUser) {
		return provider.insertThirdPartyUser(thirdUser);
	}
}
