package com.zh5j.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zh5j.common.base.BaseMapper;
import com.zh5j.sys.entity.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {
    List<Long> selectIdPage(@Param("cm") Map<String, Object> params);
}
