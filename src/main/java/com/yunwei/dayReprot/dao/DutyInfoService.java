package com.yunwei.dayReprot.dao;

import com.yunwei.dayReprot.entity.DutyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@CacheConfig
@Repository
public interface DutyInfoService {
    @Select({"select * from  dutyinfo;"})
    List<DutyInfo> selectAll();

    @Select({"select * from  dutyinfo where dayDate='${dayDate}' order by dayDate asc;"})
    DutyInfo selectByDate(String paramString);
}


