package com.xks.client.service.impl;

import com.xks.client.entity.SysLog;
import com.xks.client.mapper.SysLogMapper;
import com.xks.client.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveSysLog(SysLog syslog) {
        sysLogMapper.saveSysLog(syslog);
    }
}
