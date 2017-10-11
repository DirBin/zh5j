package com.zh5j.sys.provider;

import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysEmailConfigProvider;
import com.zh5j.sys.entity.SysEmailConfig;

/**
 * @author ShenHuaJie
 *
 */
@CacheConfig(cacheNames = "sysEmailConfig")
@Service(interfaceClass = ISysEmailConfigProvider.class)
public class SysEmailConfigProviderImpl extends BaseProviderImpl<SysEmailConfig> implements ISysEmailConfigProvider {

}
