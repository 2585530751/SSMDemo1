package com.neusoft.dao;

import com.neusoft.entity.EasybuyProductCategory;

public interface EasybuyProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyProductCategory record);

    int insertSelective(EasybuyProductCategory record);

    EasybuyProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyProductCategory record);

    int updateByPrimaryKey(EasybuyProductCategory record);
}