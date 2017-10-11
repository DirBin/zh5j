package com.zh5j.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zh5j.common.base.BaseMapper;
import com.zh5j.sys.entity.SysDept;

public interface SysDeptMapper extends BaseMapper<SysDept> {

	List<Long> selectIdPage(@Param("cm") SysDept sysDept);
}