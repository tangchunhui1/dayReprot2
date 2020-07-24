package com.yunwei.dayReport.dao;

import com.yunwei.dayReport.entity.DataLibrary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
@CacheConfig
@Repository
public interface DataLibraryService {
    @Select({"select * from  datalibrary;"})
    List<DataLibrary> selectAll();

    @Select({"select * from  datalibrary where dayDate='${dayDate}' order by dayDate asc;"})
    List<DataLibrary> selectDataByDate(String paramString);

    @Select({"SELECT *  from datalibrary  where  instanceStatus != '${instanceStatus}';"})
    List<DataLibrary> selectDataByInstanceStatus(String paramString);
}

