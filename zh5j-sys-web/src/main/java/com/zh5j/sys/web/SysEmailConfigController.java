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
import com.zh5j.common.util.DataUtil;
import com.zh5j.common.util.SecurityUtil;
import com.zh5j.sys.entity.SysEmailConfig;
import com.zh5j.sys.service.SysEmailConfigService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 邮件配置管理控制类
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:13:31
 */
@RestController
@Api(value = "邮件配置管理", description = "邮件配置管理")
@RequestMapping(value = "emailConfig")
public class SysEmailConfigController extends BaseController {
	@Autowired
	private SysEmailConfigService sysEmailConfigService;

	@ApiOperation(value = "查询邮件配置")
	@RequiresPermissions("sys.email.config.read")
	@RequestMapping(value = "/read/list", method = RequestMethod.PUT)
	public Object get(ModelMap modelMap, @RequestBody Map<String, Object> params) {
		Page<?> list = sysEmailConfigService.query(params);
		return setSuccessModelMap(modelMap, list);
	}

	@ApiOperation(value = "邮件配置详情")
	@RequiresPermissions("sys.email.config.read")
	@RequestMapping(value = "/read/detail", method = RequestMethod.PUT)
	public Object detail(ModelMap modelMap, @RequestBody SysEmailConfig params) {
		SysEmailConfig record = sysEmailConfigService.queryById(params.getId());
		return setSuccessModelMap(modelMap, record);
	}

	@ApiOperation(value = "修改邮件配置")
	@RequiresPermissions("sys.email.config.update")
	@RequestMapping(method = RequestMethod.POST)
	public Object update(ModelMap modelMap, @RequestBody SysEmailConfig record) {
		if (record.getId() != null) {
			SysEmailConfig config = sysEmailConfigService.queryById(record.getId());
			if (record.getSenderPassword() != null && !record.getSenderPassword().equals(config.getSenderPassword())) {
				record.setSenderPassword(SecurityUtil.encryptMd5(record.getSenderPassword()));
			}
		} else if (DataUtil.isNotEmpty(record.getSenderPassword())) {
			record.setSenderPassword(SecurityUtil.encryptMd5(record.getSenderPassword()));
		}
		sysEmailConfigService.update(record);
		return setSuccessModelMap(modelMap);
	}

	@ApiOperation(value = "删除邮件配置")
	@RequiresPermissions("sys.email.config.delete")
	@RequestMapping(method = RequestMethod.DELETE)
	public Object delete(ModelMap modelMap, @RequestBody SysEmailConfig record) {
		sysEmailConfigService.delete(record.getId());
		return setSuccessModelMap(modelMap);
	}
}
