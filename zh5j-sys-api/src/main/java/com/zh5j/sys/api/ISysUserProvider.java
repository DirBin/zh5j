package com.zh5j.sys.api;

import com.zh5j.common.base.BaseProvider;
import com.zh5j.common.support.login.ThirdPartyUser;
import com.zh5j.sys.entity.SysUser;

/**
 * SysUser服务接口
 * 
 * @author ShenHuaJie
 * @version 2016-08-27 22:39:42
 */
public interface ISysUserProvider extends BaseProvider<SysUser> {

	public String encryptPassword(String password);

	/** 查询第三方帐号用户Id */
	public Long queryUserIdByThirdParty(String openId, String provider);

	/** 保存第三方帐号 */
	public SysUser insertThirdPartyUser(ThirdPartyUser thirdPartyUser);

	/**
	 * 加载所有用户信息
	 */
	public void init();
}
