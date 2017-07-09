package com.web.dao;

import com.web.entity.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Mew on 2017/7/8.
 */
public interface TransactionDao {
    @Select("SELECT * FROM trx where contentId = #{id};")
    Transaction getTransaction(int id);

    @Insert("insert into trx (contentId,personId,price,time) VALUES(#{contentId},#{personId},#{price},#{time});")
    void InsertTransaction(Transaction transaction);
}
