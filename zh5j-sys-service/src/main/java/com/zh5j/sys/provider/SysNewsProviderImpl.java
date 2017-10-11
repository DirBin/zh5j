package com.zh5j.sys.provider;

import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysNewsProvider;
import com.zh5j.sys.entity.SysNews;

/**
 * @author ShenHuaJie
 *
 */
@CacheConfig(cacheNames = "sysNews")
@Service(interfaceClass = ISysNewsProvider.class)
public class SysNewsProviderImpl extends BaseProviderImpl<SysNews> implements ISysNewsProvider {

}
