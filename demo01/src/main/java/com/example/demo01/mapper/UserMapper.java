package com.example.demo01.mapper;

import com.example.demo01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>{

    @Select("select count(1) from user")
    public int count();

    @Select("select * from user limit #{page},#{limit}")
    public List<User> InfoAll(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from user where name LIKE '%${username}%' limit #{page},#{limit}")
    public List<User> getInfoByName(@Param("username") String name,@Param("page") int page, @Param("limit") int limit);
}
