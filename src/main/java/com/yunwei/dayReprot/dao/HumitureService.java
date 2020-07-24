package com.yunwei.dayReprot.dao;

import com.yunwei.dayReprot.entity.Humiture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@CacheConfig
@Repository
public interface HumitureService {
    @Select({"select * from  humiture;"})
    List<Humiture> selectAll();

    @Select({"select * from  humiture where dayDate='${dayDate}' order by dayDate asc; "})
    List<Humiture> selectByDate(String paramString);

    @Select({"select * from  humiture where  region like'${region}%';"})
    Humiture selectByRegion(String paramString);
}

