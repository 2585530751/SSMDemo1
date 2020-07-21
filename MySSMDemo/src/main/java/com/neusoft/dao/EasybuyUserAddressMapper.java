package com.neusoft.dao;

import com.neusoft.entity.EasybuyUserAddress;

public interface EasybuyUserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUserAddress record);

    int insertSelective(EasybuyUserAddress record);

    EasybuyUserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyUserAddress record);

    int updateByPrimaryKey(EasybuyUserAddress record);
}