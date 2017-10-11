package com.zh5j.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zh5j.common.base.BaseMapper;
import com.zh5j.sys.entity.SysUserMenu;

public interface SysUserMenuMapper extends BaseMapper<SysUserMenu> {
	List<Long> queryMenuIdsByUserId(@Param("userId") Long userId);

	List<Map<String, Object>> queryPermissions(@Param("userId") Long userId);

	List<String> queryPermission(@Param("userId") Long id);
}