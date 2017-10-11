package com.zh5j.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zh5j.common.base.BaseMapper;
import com.zh5j.sys.entity.SysMenu;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
	/** 获取所有权限 */
	public List<Map<String, String>> getPermissions();

	public List<Long> selectIdPage(@Param("cm") Map<String, Object> params);
}