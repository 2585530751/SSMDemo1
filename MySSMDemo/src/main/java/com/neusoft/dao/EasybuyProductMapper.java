package com.neusoft.dao;

import com.neusoft.entity.EasybuyProduct;

public interface EasybuyProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyProduct record);

    int insertSelective(EasybuyProduct record);

    EasybuyProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyProduct record);

    int updateByPrimaryKey(EasybuyProduct record);
}