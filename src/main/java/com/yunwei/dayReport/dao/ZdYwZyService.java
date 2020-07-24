package com.yunwei.dayReport.dao;

import com.yunwei.dayReport.entity.ZdYwZy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
@CacheConfig
@Repository
public interface ZdYwZyService {
    @Select({"select * from zdywzy where id = # {id}"})
    ZdYwZy selectzdywzyById(int paramInt);

    @Select({"SELECT *  from  zdywzy  where  locate(#{date1},date) order by date asc"})
    List<ZdYwZy> selectzdywzyByDate(String paramString);

    @Select({"select * from  zdywzy"})
    List<ZdYwZy> selectzdywzy();
}
