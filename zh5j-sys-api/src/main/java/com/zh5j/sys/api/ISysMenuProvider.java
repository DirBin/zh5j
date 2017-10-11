package com.zh5j.sys.api;

import java.util.List;
import java.util.Map;

import com.zh5j.common.base.BaseProvider;
import com.zh5j.sys.entity.SysMenu;

public interface ISysMenuProvider extends BaseProvider<SysMenu> {
	/** 获取所有权限选项(value-text) */
	public List<Map<String, String>> getPermissions();
}
