/**
 * 
 */
package com.zh5j.sys.api;

import java.util.List;

import com.zh5j.common.base.BaseProvider;
import com.zh5j.sys.entity.SysSession;

/**
 * @author ShenHuaJie
 * @version 2016年5月15日 上午11:21:21
 */
public interface ISysSessionProvider extends BaseProvider<SysSession> {
	public void deleteBySessionId(final String sessionId);

	public List<String> querySessionIdByAccount(String account);

	public void delete(Long id);
	
	public void cleanExpiredSessions();
}
