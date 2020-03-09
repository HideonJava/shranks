package com.xks.client.mapper;

import com.xks.client.entity.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SysLogMapper {
    @Insert("insert into sys_log(username,operation,time,method,params,ip,createTime)" +
            " values(#{username},#{operation},#{time},#{method},#{params},#{ip},#{createTime})")
    void saveSysLog(SysLog syslog);
}
