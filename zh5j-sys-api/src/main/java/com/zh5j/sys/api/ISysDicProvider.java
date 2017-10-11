package com.zh5j.sys.api;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.base.BaseProvider;
import com.zh5j.sys.entity.SysDic;

public interface ISysDicProvider extends BaseProvider<SysDic> {
	public Map<String, Map<String, String>> getAllDic();

	public void updateDic(SysDic record);

	public void deleteDic(Long id);

	public Page<SysDic> queryDic(Map<String, Object> params);

	public Map<String, String> queryDicByDicIndexKey(String key);
}
