package com.zh5j.sys.web;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.base.BaseController;
import com.zh5j.sys.entity.SysNotice;
import com.zh5j.sys.service.SysNoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 通知管理控制类
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:13:31
 */
@RestController
@Api(value = "通知管理", description = "通知管理")
@RequestMapping(value = "notice")
public class SysNoticeController extends BaseController {
	@Autowired
	private SysNoticeService sysNoticeService;

	@ApiOperation(value = "查询通知")
	@RequiresPermissions("public.notice.read")
	@RequestMapping(value = "/read/list", method = RequestMethod.PUT)
	public Object get(ModelMap modelMap, @RequestBody Map<String, Object> params) {
		Page<?> list = sysNoticeService.query(params);
		return setSuccessModelMap(modelMap, list);
	}

	@ApiOperation(value = "通知详情")
	@RequiresPermissions("public.notice.read")
	@RequestMapping(value = "/read/detail", method = RequestMethod.PUT)
	public Object detail(ModelMap modelMap, @RequestBody SysNotice params) {
		SysNotice record = sysNoticeService.queryById(params.getId());
		return setSuccessModelMap(modelMap, record);
	}

	@ApiOperation(value = "修改通知")
	@RequiresPermissions("public.notice.update")
	@RequestMapping(method = RequestMethod.POST)
	public Object update(ModelMap modelMap, @RequestBody SysNotice record) {
		sysNoticeService.update(record);
		return setSuccessModelMap(modelMap);
	}

	@ApiOperation(value = "删除通知")
	@RequiresPermissions("public.notice.delete")
	@RequestMapping(method = RequestMethod.DELETE)
	public Object delete(ModelMap modelMap, @RequestBody SysNotice record) {
		sysNoticeService.delete(record.getId());
		return setSuccessModelMap(modelMap);
	}
}
