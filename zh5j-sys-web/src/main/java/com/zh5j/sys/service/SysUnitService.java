package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysUnitProvider;
import com.zh5j.sys.entity.SysUnit;

/**
 * 单位管理
 * @author ShenHuaJie
 */
@Service
public class SysUnitService extends BaseService<ISysUnitProvider, SysUnit> {
	@Reference
	public void setProvider(ISysUnitProvider provider) {
		this.provider = provider;
	}
}
