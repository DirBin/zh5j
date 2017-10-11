package com.zh5j.sys.provider;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysDeptProvider;
import com.zh5j.sys.api.ISysRoleProvider;
import com.zh5j.sys.entity.SysDept;
import com.zh5j.sys.entity.SysRole;
import com.zh5j.sys.mapper.SysRoleMenuMapper;

/**
 * @author ShenHuaJie
 * @version 2016年5月31日 上午11:01:33
 */
@CacheConfig(cacheNames = "sysRole")
@Service(interfaceClass = ISysRoleProvider.class)
public class SysRoleProviderImpl extends BaseProviderImpl<SysRole> implements ISysRoleProvider {
	@Autowired
	private ISysDeptProvider sysDeptProvider;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	public Page<SysRole> query(Map<String, Object> params) {
		Page<SysRole> pageInfo = super.query(params);
		// 权限信息
		for (SysRole bean : pageInfo.getRecords()) {
			if (bean.getDeptId() != null) {
				SysDept sysDept = sysDeptProvider.queryById(bean.getDeptId());
				bean.setDeptName(sysDept.getDeptName());
			}
			List<String> permissions = sysRoleMenuMapper.queryPermission(bean.getId());
			for (String permission : permissions) {
				if (StringUtils.isBlank(bean.getPermission())) {
					bean.setPermission(permission);
				} else {
					bean.setPermission(bean.getPermission() + ";" + permission);
				}
			}
		}
		return pageInfo;
	}
}
