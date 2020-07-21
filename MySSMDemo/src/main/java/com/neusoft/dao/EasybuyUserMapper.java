package com.neusoft.dao;

import com.neusoft.entity.EasybuyUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户的数据访问接口
 */
public interface EasybuyUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUser record);

    int insertSelective(EasybuyUser record);

    EasybuyUser selectByPrimaryKey(Integer id);

    EasybuyUser selectByUnameAndPwd(@Param("uname") String uname, @Param("upwd") String upwd);

    int updateByPrimaryKeySelective(EasybuyUser record);

    int updateByPrimaryKey(EasybuyUser record);
}