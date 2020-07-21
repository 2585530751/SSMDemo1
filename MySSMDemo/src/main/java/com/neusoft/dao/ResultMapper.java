package com.neusoft.dao;

import com.neusoft.entity.Result;

public interface ResultMapper {
    int insert(Result record);

    int insertSelective(Result record);
}