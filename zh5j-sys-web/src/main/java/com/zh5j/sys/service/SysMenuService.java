package com.zh5j.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysMenuProvider;
import com.zh5j.sys.entity.SysMenu;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:07
 */
@Service
public class SysMenuService extends BaseService<ISysMenuProvider, SysMenu> {
	@Reference
	public void setProvider(ISysMenuProvider provider) {
		this.provider = provider;
	}

	public List<Map<String, String>> getPermissions() {
		return provider.getPermissions();
	}
}
