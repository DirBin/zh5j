package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysNoticeProvider;
import com.zh5j.sys.entity.SysNotice;

/**
 * 通知管理
 * @author ShenHuaJie
 */
@Service
public class SysNoticeService extends BaseService<ISysNoticeProvider, SysNotice> {
	@Reference
	public void setProvider(ISysNoticeProvider provider) {
		this.provider = provider;
	}
}
