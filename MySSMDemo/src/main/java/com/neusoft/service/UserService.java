package com.neusoft.service;

import com.neusoft.entity.EasybuyUser;

/**
 * 用户的业务逻辑接口
 */
public interface UserService {

    EasybuyUser getUser(int uid);

    EasybuyUser getUser(String uname, String upwd);
}
