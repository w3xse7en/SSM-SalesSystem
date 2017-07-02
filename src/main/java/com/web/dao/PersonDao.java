package com.web.dao;

import com.web.entity.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Mew on 2017/6/30.
 */

public interface PersonDao {
    @Select("select * from person where userName = #{userName} and userPassword = #{userPassword}")
    Person getPerson(@Param("userName") String userName, @Param("userPassword") String userPassword);

    @Select("select userPassword from person where userName = #{userName}")
    String getuserPassword(String userName);

    @Select("select userType from person where userName = #{userName}")
    int getuserType(String userName);

}
