package com.zh5j.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.support.Assert;
import com.zh5j.common.support.scheduler.TaskScheduled;
import com.zh5j.model.TaskFireLog;
import com.zh5j.sys.api.ISchedulerProvider;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:20
 */
@Service
public class SchedulerService {
	@Reference // 依赖调度服务
	private ISchedulerProvider schedulerProvider;

	public Page<TaskScheduled> getAllTaskDetail() {
		List<TaskScheduled> records = schedulerProvider.getAllTaskDetail();
		Page<TaskScheduled> pageInfo = new Page<TaskScheduled>(1, records.size());
		pageInfo.setRecords(records);
		pageInfo.setTotal(records.size());
		return pageInfo;
	}

	// 修改执行计划
	public void updateTask(TaskScheduled scheduled) {
		Assert.notNull(scheduled.getJobType(), "JOBTYPE");
		Assert.notNull(scheduled.getTaskType(), "TASKTYPE");
		Assert.notNull(scheduled.getTargetObject(), "TARGETOBJECT");
		Assert.notNull(scheduled.getTargetMethod(), "TARGETMETHOD");
		Assert.notNull(scheduled.getTaskCron(), "TASKCRON");
		Assert.notNull(scheduled.getTaskDesc(), "TASKDESC");
		schedulerProvider.updateTask(scheduled);
	}

	public void execTask(String taskGroup, String taskName) {
		Assert.notNull(taskGroup, "TASKGROUP");
		Assert.notNull(taskName, "TASKNAME");
		schedulerProvider.execTask(taskGroup, taskName);
	}

	public void openTask(String taskGroup, String taskName) {
		Assert.notNull(taskGroup, "TASKGROUP");
		Assert.notNull(taskName, "TASKNAME");
		schedulerProvider.openTask(taskGroup, taskName);
	}

	public void closeTask(String taskGroup, String taskName) {
		Assert.notNull(taskGroup, "TASKGROUP");
		Assert.notNull(taskName, "TASKNAME");
		schedulerProvider.closeTask(taskGroup, taskName);
	}

	public void delTask(String taskGroup, String taskName) {
		Assert.notNull(taskGroup, "TASKGROUP");
		Assert.notNull(taskName, "TASKNAME");
		schedulerProvider.delTask(taskGroup, taskName);
	}

	public Page<TaskFireLog> queryLog(Map<String, Object> params) {
		return schedulerProvider.queryLog(params);
	}
}
