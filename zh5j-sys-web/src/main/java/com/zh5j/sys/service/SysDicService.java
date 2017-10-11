package com.zh5j.sys.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.support.Assert;
import com.zh5j.common.util.WebUtil;
import com.zh5j.sys.api.ISysDicProvider;
import com.zh5j.sys.entity.SysDic;

@Service
public class SysDicService {
	@Reference
	private ISysDicProvider provider;

	public Page<SysDic> queryDic(Map<String, Object> params) {
		return provider.queryDic(params);
	}

	public void addDic(SysDic record) {
		record.setCreateBy(WebUtil.getCurrentUser());
		provider.updateDic(record);
	}

	public void updateDic(SysDic record) {
		Assert.notNull(record.getId(), "ID");
		record.setUpdateBy(WebUtil.getCurrentUser());
		provider.updateDic(record);
	}

	public void deleteDic(Long id) {
		Assert.notNull(id, "ID");
		provider.deleteDic(id);
	}

	public SysDic queryDicById(Long id) {
		return provider.queryById(id);
	}

	public Map<String, String> queryDicByDicIndexKey(String key) {
		Assert.notNull(key, "KEY");
		return provider.queryDicByDicIndexKey(key);
	}

}
