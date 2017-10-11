package com.zh5j.sys.provider;

import org.springframework.cache.annotation.CacheConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.sys.api.ISysNoticeProvider;
import com.zh5j.sys.entity.SysNotice;

/**
 * @author ShenHuaJie
 *
 */
@CacheConfig(cacheNames = "sysNoticeTemplate")
@Service(interfaceClass = ISysNoticeProvider.class)
public class SysNoticeProviderImpl extends BaseProviderImpl<SysNotice> implements ISysNoticeProvider {

}
