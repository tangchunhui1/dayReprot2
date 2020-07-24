package com.yunwei.dayReprot.dao;

import com.yunwei.dayReprot.entity.Distribution;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

@Mapper
@CacheConfig
@Repository
public interface DistributionService {
  @Select({"select * from  distribution;"})
  List<Distribution> selectAll();

  @Select({"select * from  distribution where dayDate='${dayDate}' order by dayDate asc;"})
  List<Distribution> selectByDate(String paramString);

  @Select({"select * from  distribution where electrofacies ='${electrofacies}' order by id asc；"})
  List<Distribution> selectByElectrofacies(String paramString);

  @Select({"select * from distribution where region = '${region}'"})
  List<Distribution> selectByRegin(String paramString);
}
