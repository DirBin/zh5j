package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysNewsProvider;
import com.zh5j.sys.entity.SysNews;

/**
 * 新闻管理
 * @author ShenHuaJie
 */
@Service
public class SysNewsService extends BaseService<ISysNewsProvider, SysNews> {
	@Reference
	public void setProvider(ISysNewsProvider provider) {
		this.provider = provider;
	}
}
