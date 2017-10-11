package com.zh5j.sys.provider;

import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysDeptProvider;
import com.zh5j.sys.entity.SysDept;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
@CacheConfig(cacheNames = "sysDept")
@Service(interfaceClass = ISysDeptProvider.class)
public class SysDeptProviderImpl extends BaseProviderImpl<SysDept> implements ISysDeptProvider {
	
}
