package com.zh5j.common.support;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.model.SysEvent;

public interface ISysEventService {
	public void update(SysEvent sysEvent);

	public Page<?> queryMap(Map<String, Object> params);
}
