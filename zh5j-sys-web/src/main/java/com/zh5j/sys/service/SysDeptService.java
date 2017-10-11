package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysDeptProvider;
import com.zh5j.sys.entity.SysDept;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:07
 */
@Service
public class SysDeptService extends BaseService<ISysDeptProvider, SysDept> {
	@Reference
	public void setProvider(ISysDeptProvider provider) {
		this.provider = provider;
	}
}
