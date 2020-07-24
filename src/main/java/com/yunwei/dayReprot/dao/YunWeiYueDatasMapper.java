package com.yunwei.dayReprot.dao;

import com.yunwei.dayReprot.entity.YunWeiYueDatas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@CacheConfig
@Repository
public interface YunWeiYueDatasMapper {
    @Select({"select *  from yunweiyuedatas  where  locate(#{date1},date) order by date asc"})
    List<YunWeiYueDatas> selectYwydatasByDate(String paramString);

    @Select({"select * from  yunweiyuedatas"})
    List<YunWeiYueDatas> selectAllYwydatas();
}

