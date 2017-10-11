package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysEmailTemplateProvider;
import com.zh5j.sys.entity.SysEmailTemplate;

/**
 * 邮件模版管理
 * @author ShenHuaJie
 */
@Service
public class SysEmailTemplateService extends BaseService<ISysEmailTemplateProvider, SysEmailTemplate> {
	@Reference
	public void setProvider(ISysEmailTemplateProvider provider) {
		this.provider = provider;
	}
}
