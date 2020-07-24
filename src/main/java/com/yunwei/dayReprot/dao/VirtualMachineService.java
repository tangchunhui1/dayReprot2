package com.yunwei.dayReprot.dao;

import com.yunwei.dayReprot.entity.VirtualMachine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@CacheConfig
@Repository
public interface VirtualMachineService {
    @Select({"select * from  virtualmachine ;"})
    List<VirtualMachine> selectAll();

    @Select({"select * from  virtualmachine  where dayDate='${dayDate}' order by dayDate asc;"})
    List<VirtualMachine> selectByDate(String paramString);

    @Select({"select * from  virtualmachine  where category ='${category}' and dayDate='${dayDate}' order by dayDate asc;"})
    List<VirtualMachine> selectByCategoryAndDaydate(String paramString1, String paramString2);

    @Select({"select * from  virtualmachine  where cpuPeak >'${cpuPeak}';"})
    List<VirtualMachine> selectByCpuPeak(String paramString);

    @Select({" select * from  virtualmachine  where memoryPeak >'${memoryPeak}'"})
    List<VirtualMachine> selectByMemoryPeak(String paramString);

    @Select({"SELECT *  from  virtualmachine  where responseTime >'${responseTime}'"})
    List<VirtualMachine> selectByResponseTime(String paramString);
}

