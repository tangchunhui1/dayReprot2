package com.yunwei.dayReport.dao;

import com.yunwei.dayReport.entity.Servicer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
@CacheConfig
@Repository
public interface ServicerService {
    @Select({"select * from  servicer ;"})
    List<Servicer> selectAll();

    @Select({"select * from  servicer  where dayDate='${dayDate}' order by dayDate asc;"})
    List<Servicer> selectByDate(String paramString);

    @Select({"select * from  servicer  where cpuPeak >'${cpuPeak}';"})
    List<Servicer> selectByCpuPeak(String paramString);

    @Select({" select * from  servicer  where memoryPeak >'${memoryPeak}'"})
    List<Servicer> selectByMemoryPeak(String paramString);

    @Select({"SELECT *  from  servicer  where responseTime >'${responseTime}'"})
    List<Servicer> selectByResponseTime(String paramString);
}
