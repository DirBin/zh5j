package com.zh5j.sys.provider;

import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysEmailTemplateProvider;
import com.zh5j.sys.entity.SysEmailTemplate;

/**
 * @author ShenHuaJie
 *
 */
@CacheConfig(cacheNames = "sysEmailTemplate")
@Service(interfaceClass = ISysEmailTemplateProvider.class)
public class SysEmailTemplateProviderImpl extends BaseProviderImpl<SysEmailTemplate>
		implements ISysEmailTemplateProvider {

}
