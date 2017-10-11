package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysEmailConfigProvider;
import com.zh5j.sys.entity.SysEmailConfig;

/**
 * 邮件配置管理
 * @author ShenHuaJie
 */
@Service
public class SysEmailConfigService extends BaseService<ISysEmailConfigProvider, SysEmailConfig> {
	@Reference
	public void setProvider(ISysEmailConfigProvider provider) {
		this.provider = provider;
	}
}
