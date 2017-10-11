package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysEmailProvider;
import com.zh5j.sys.entity.SysEmail;

/**
 * 邮件管理
 * @author ShenHuaJie
 */
@Service
public class SysEmailService extends BaseService<ISysEmailProvider, SysEmail> {
	@Reference
	public void setProvider(ISysEmailProvider provider) {
		this.provider = provider;
	}
}
