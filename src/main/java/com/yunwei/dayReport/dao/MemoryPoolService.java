package com.yunwei.dayReport.dao;

import com.yunwei.dayReport.entity.MemoryPool;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

@Mapper
@CacheConfig
@Repository
public interface MemoryPoolService {
  @Select({"select * from  memorypool;"})
  List<MemoryPool> selectAll();

  @Select({"select * from  memorypool where dayDate='${dayDate}' order by dayDate asc;"})
  List<MemoryPool> selectByDate(String paramString);

  @Select({"select * from  memorypool where category  like '%${category}%' ;"})
  List<MemoryPool> selectByCategory(String paramString);
}

