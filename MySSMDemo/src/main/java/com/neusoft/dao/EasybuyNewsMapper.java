package com.neusoft.dao;

import com.neusoft.entity.EasybuyNews;

public interface EasybuyNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyNews record);

    int insertSelective(EasybuyNews record);

    EasybuyNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyNews record);

    int updateByPrimaryKey(EasybuyNews record);
}