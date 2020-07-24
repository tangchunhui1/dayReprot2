package com.yunwei.dayReport.dao;

import com.yunwei.dayReport.entity.CloudResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
@CacheConfig
@Repository
public interface CloudResourceService {
    @Select({"select * from  cloudresource"})
    List<CloudResource> selectAll();

    @Select({"select * from  cloudresource where  dayDate='${dayDate}' order by dayDate asc"})
    List<CloudResource> selectByDate(String paramString);

    @Select({"select * from cloudresource where category  like '%${category}%'"})
    List<CloudResource> selectByCategory(String paramString);

    @Select({"SELECT *  from  cloudresource  where cpuUsage >'${cpuUsage}'"})
    List<CloudResource> selectByCpuUsage(String paramString);

    @Select({"SELECT *  from  cloudresource  where cpuUsage >'${memoryUsage}'"})
    List<CloudResource> selectByMemoryUsage(String paramString);
}


