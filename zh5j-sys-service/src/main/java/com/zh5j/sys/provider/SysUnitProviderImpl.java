package com.zh5j.sys.provider;

import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysUnitProvider;
import com.zh5j.sys.entity.SysUnit;

/**
 * @author ShenHuaJie
 *
 */
@CacheConfig(cacheNames = "sysUnit")
@Service(interfaceClass = ISysUnitProvider.class)
public class SysUnitProviderImpl extends BaseProviderImpl<SysUnit> implements ISysUnitProvider {

}
