package com.zh5j.common.support.scheduler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.base.BaseProviderImpl;
import com.zh5j.common.util.InstanceUtil;
import com.zh5j.mapper.TaskFireLogMapper;
import com.zh5j.model.TaskFireLog;

/**
 * @author ShenHuaJie
 * @version 2016年7月1日 上午11:34:59
 */
public class SchedulerService implements ApplicationContextAware {
	@Autowired
	private TaskFireLogMapper logMapper;
	@Autowired
	private SchedulerManager schedulerManager;
	protected ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	// 获取所有作业
	public List<TaskScheduled> getAllTaskDetail() {
		return schedulerManager.getAllJobDetail();
	}

	// 执行作业
	public void execTask(String taskGroup, String taskName) {
		TaskScheduled taskScheduled = new TaskScheduled(taskGroup, taskName);
		schedulerManager.runJob(taskScheduled);
	}

	// 恢复作业
	public void openTask(String taskGroup, String taskName) {
		TaskScheduled taskScheduled = new TaskScheduled(taskGroup, taskName);
		schedulerManager.resumeJob(taskScheduled);
	}

	// 暂停作业
	public void closeTask(String taskGroup, String taskName) {
		TaskScheduled taskScheduled = new TaskScheduled(taskGroup, taskName);
		schedulerManager.stopJob(taskScheduled);
	}

	// 删除作业
	public void delTask(String taskGroup, String taskName) {
		TaskScheduled taskScheduled = new TaskScheduled(taskGroup, taskName);
		schedulerManager.delJob(taskScheduled);
	}

	// 修改任务
	public void updateTask(TaskScheduled taskScheduled) {
		schedulerManager.updateTask(taskScheduled);
	}

	@Cacheable("taskFireLog")
	public TaskFireLog getFireLogById(Long id) {
		return logMapper.selectById(id);
	}

	@Transactional
	@CachePut("taskFireLog")
	public TaskFireLog updateLog(TaskFireLog record) {
		if (record.getId() == null) {
			logMapper.insert(record);
		} else {
			logMapper.updateById(record);
		}
		return record;
	}

	public Page<TaskFireLog> queryLog(Map<String, Object> params) {
		Page<Long> ids = BaseProviderImpl.getPage(params);
		ids.setRecords(logMapper.selectIdByMap(ids, params));
		Page<TaskFireLog> page = new Page<TaskFireLog>(ids.getCurrent(), ids.getSize());
		page.setTotal(ids.getTotal());
		if (ids != null) {
			List<TaskFireLog> records = InstanceUtil.newArrayList();
			for (Long id : ids.getRecords()) {
				records.add(applicationContext.getBean(getClass()).getFireLogById(id));
			}
			page.setRecords(records);
		}
		return page;
	}
}
