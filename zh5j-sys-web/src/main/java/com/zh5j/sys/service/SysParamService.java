package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.sys.api.ISysParamProvider;
import com.zh5j.sys.entity.SysParam;

/**
 * @author ShenHuaJie
 * @version 2016年5月31日 上午11:09:40
 */
@Service
public class SysParamService extends BaseService<ISysParamProvider, SysParam> {
	@Reference
	public void setProvider(ISysParamProvider provider) {
		this.provider = provider;
	}
}
