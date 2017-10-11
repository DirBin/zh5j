package com.zh5j.sys.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zh5j.common.base.BaseService;
import com.zh5j.common.support.ISysEventService;
import com.zh5j.model.SysEvent;
import com.zh5j.sys.api.ISysEventProvider;

@Service
public class SysEventService extends BaseService<ISysEventProvider, SysEvent> implements ISysEventService {
	@Reference
	public void setProvider(ISysEventProvider provider) {
		this.provider = provider;
	}
}
