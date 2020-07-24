package com.yunwei.dayReport.dao;

import com.yunwei.dayReport.entity.YueGongDan;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
@CacheConfig
@Repository
public interface YueGonDanMapper {
    @Select({"select * from Yuegongdan where id = # {id}"})
    YueGongDan selectGongDanById(int paramInt);

    @Select({"SELECT *  from Yuegongdan  where  locate(#{date1},date) order by date asc"})
    List<YueGongDan> selectGongDanByDate(String paramString);

    @Select({"select * from  Yuegongdan"})
    List<YueGongDan> selectAllGongDan();

    @Insert({"insert into Yuegondan(date,gdType,gdNum) values (#{date},#{gdType},#{gdNum})"})
    void addgondan(YueGongDan paramYueGongDan);

    @Update({"update Yuegondan set date=#{date},gdType=#{gdType},gdNum=#{gdNum} where id=#{id}"})
    void updategondan(YueGongDan paramYueGongDan);

    @Delete({"delete from Yuegondan where id=#{id}"})
    void deletegondan(int paramInt);
}

