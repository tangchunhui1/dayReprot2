package com.yunwei.dayReprot.dao;

import com.yunwei.dayReprot.entity.NetDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@CacheConfig
@Repository
public interface NetDeviceService {
    @Select({"select * from  netdevice ;"})
    List<NetDevice> selectAll();

    @Select({"select * from  netdevice  where dayDate='${dayDate}' order by dayDate asc;"})
    List<NetDevice> selectByDate(String paramString);

    @Select({"select * from  netdevice  where cpuPeak >'${cpuPeak}';"})
    List<NetDevice> selectByCpuPeak(String paramString);

    @Select({" select * from  netdevice  where memoryPeak >'${memoryPeak}'"})
    List<NetDevice> selectByMemoryPeak(String paramString);

    @Select({"SELECT *  from  netdevice  where responseTime >'${responseTime}'"})
    List<NetDevice> selectByResponseTime(String paramString);
}

