package com.zh5j.sys.provider;

import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysEmailProvider;
import com.zh5j.sys.entity.SysEmail;

/**
 * @author ShenHuaJie
 *
 */
@CacheConfig(cacheNames = "sysEmail")
@Service(interfaceClass = ISysEmailProvider.class)
public class SysEmailProviderImpl extends BaseProviderImpl<SysEmail> implements ISysEmailProvider {

}
