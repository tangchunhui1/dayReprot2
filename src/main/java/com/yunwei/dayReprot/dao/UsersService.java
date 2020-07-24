package com.yunwei.dayReprot.dao;

import com.yunwei.dayReprot.entity.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@CacheConfig
@Repository
public interface UsersService {
    @Select({"select * from users where userName ='${userName}' and  passWord='${passWord}'"})
    Users selectUserlogin(String paramString1, String paramString2);

    @Select({"select passWord from users where userName ='${userName}'"})
    String getPassWord(String paramString);

    @Select({"select userName from users where userName ='${userName}'"})
    String getUserName(String paramString);

    @Select({"SELECT *  from users  where  locate(#{date1},date) order by date asc"})
    List<Users> selectUserByDate(String paramString);

    @Select({"select * from  users"})
    List<Users> selectUsers();

    @Insert({"insert into users(id,userName,passWord,role) values (#{id},#{userName},#{passWord})"})
    void adduser(Users paramUsers);

    @Update({"update users set date=#{date},userName=#{userName},passWord=#{passWord},role=#{role} where id=#{id}"})
    void updateuser(Users paramUsers);

    @Delete({"delete from users where id=#{id}"})
    void deleteuser(int paramInt);
}

