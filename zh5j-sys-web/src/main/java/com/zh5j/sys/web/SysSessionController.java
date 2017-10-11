package com.zh5j.sys.web;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.base.BaseController;
import com.zh5j.sys.common.listener.SessionListener;
import com.zh5j.sys.entity.SysSession;
import com.zh5j.sys.service.SysSessionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户会话管理
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:13:06
 */
@RestController
@Api(value = "会话管理", description = "会话管理")
@RequestMapping(value = "/session")
public class SysSessionController extends BaseController {
	@Autowired
	private SysSessionService sysSessionService;

	// 查询会话
	@ApiOperation(value = "查询会话")
	@PutMapping(value = "/read/list")
	@RequiresPermissions("sys.base.session.read")
	public Object get(ModelMap modelMap, @RequestBody(required = false) Map<String, Object> sysSession) {
		Page<?> list = sysSessionService.query(sysSession);
		Integer number = SessionListener.getAllUserNumber();
		modelMap.put("userNumber", number); // 用户数大于会话数,有用户没有登录
		return setSuccessModelMap(modelMap, list);
	}

	@DeleteMapping
	@ApiOperation(value = "删除会话")
	@RequiresPermissions("sys.base.session.delete")
	public Object update(ModelMap modelMap, @RequestBody SysSession param) {
		sysSessionService.delete(param.getId());
		return setSuccessModelMap(modelMap);
	}
}
