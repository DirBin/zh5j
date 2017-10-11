package com.zh5j.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zh5j.common.support.Assert;
import com.zh5j.sys.api.ISysSessionProvider;
import com.zh5j.sys.entity.SysSession;

/**
 * 会话管理
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:08:32
 */
@Service
public class SysSessionService {
	@Autowired
	private ISysSessionProvider sysSessionProvider;
	@Autowired
	private RedisOperationsSessionRepository sessionRepository;

	public Page<?> query(Map<String, Object> params) {
		return sysSessionProvider.query(params);
	}

	/** 删除会话 */
	public void deleteByAccount(String account, String currentSessionId) {
		Assert.isNotBlank(account, "ACCOUNT");
		List<String> sessionIds = sysSessionProvider.querySessionIdByAccount(account);
		if (sessionIds != null) {
			for (String sessionId : sessionIds) {
				sysSessionProvider.deleteBySessionId(sessionId);
				if (!sessionId.equals(currentSessionId)) {
					sessionRepository.delete(sessionId);
					sessionRepository.cleanupExpiredSessions();
				}
			}
		}
	}

	/** 删除会话 */
	public void delete(Long id) {
		Assert.notNull(id, "ID");
		SysSession sysSession = sysSessionProvider.queryById(id);
		if (sysSession != null) {
			sysSessionProvider.delete(id);
			sessionRepository.delete(sysSession.getSessionId());
		}
	}

	/** 更新会话 */
	public void update(SysSession record) {
		sysSessionProvider.update(record);
	}

	/** 删除会话 */
	public void deleteBySessionId(String sessionId) {
		sysSessionProvider.deleteBySessionId(sessionId);
	}

}
