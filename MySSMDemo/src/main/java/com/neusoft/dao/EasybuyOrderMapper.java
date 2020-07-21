package com.neusoft.dao;

import com.neusoft.entity.EasybuyOrder;

public interface EasybuyOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyOrder record);

    int insertSelective(EasybuyOrder record);

    EasybuyOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyOrder record);

    int updateByPrimaryKey(EasybuyOrder record);
}