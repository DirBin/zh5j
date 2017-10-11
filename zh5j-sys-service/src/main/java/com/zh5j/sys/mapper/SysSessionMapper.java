package com.zh5j.sys.mapper;

import java.util.List;

import com.zh5j.common.base.BaseMapper;
import com.zh5j.sys.entity.SysSession;

public interface SysSessionMapper extends BaseMapper<SysSession> {

    void deleteBySessionId(String sessionId);

    Long queryBySessionId(String sessionId);

    List<String> querySessionIdByAccount(String account);
}