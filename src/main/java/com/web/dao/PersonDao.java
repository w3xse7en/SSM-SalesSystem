package com.web.dao;

import com.web.entity.Person;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Mew on 2017/6/30.
 */

public interface PersonDao {
    @Select("select * from person where id = #{id}")
    Person getContent(int id);

}
