package com.zh5j.sys.mapper;

import org.apache.ibatis.annotations.Param;

import com.zh5j.common.base.BaseMapper;
import com.zh5j.sys.entity.SysUserThirdparty;

public interface SysUserThirdpartyMapper extends BaseMapper<SysUserThirdparty> {
	Long queryUserIdByThirdParty(@Param("provider") String provider, @Param("openId") String openId);
}