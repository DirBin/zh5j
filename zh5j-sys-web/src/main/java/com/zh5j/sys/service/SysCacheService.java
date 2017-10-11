package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.sys.api.ISysCacheProvider;

@Service
public class SysCacheService {
	@Reference(async = true)
	private ISysCacheProvider sysCacheProvider;

	public void flushCache() {
		sysCacheProvider.flush();
	}
}
