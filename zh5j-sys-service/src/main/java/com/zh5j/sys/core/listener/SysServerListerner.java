package com.zh5j.sys.core.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.zh5j.common.core.listener.ServerListener;
import com.zh5j.sys.api.ISysDicProvider;
import com.zh5j.sys.api.ISysUserProvider;

public class SysServerListerner extends ServerListener {
	protected final Logger logger = LogManager.getLogger(this.getClass());

	public void contextInitialized(ServletContextEvent contextEvent) {
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		context.getBean(ISysUserProvider.class).init();
		ISysDicProvider sysDicProvider = context.getBean(ISysDicProvider.class);
		Map<String, Map<String, String>> a = sysDicProvider.getAllDic();
		for(String b:a.keySet()){
			System.out.println("查询开始》》》》》》》》》》》》》》》》》》》》》》》");
			System.out.println(b+":"+a.get(b));
			System.out.println("查询结束》》》》》》》》》》》》》》》》》》》》》》》");
		}
		super.contextInitialized(contextEvent);
	}
}