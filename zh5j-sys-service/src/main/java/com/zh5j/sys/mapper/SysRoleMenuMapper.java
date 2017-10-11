package com.zh5j.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zh5j.common.base.BaseMapper;
import com.zh5j.sys.entity.SysRoleMenu;

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
	List<Long> queryMenuIdsByRoleId(@Param("roleId") Long roleId);

	List<Map<String, Object>> queryPermissions(@Param("roleId") Long roleId);

	List<String> queryPermission(@Param("roleId") Long id);
}
