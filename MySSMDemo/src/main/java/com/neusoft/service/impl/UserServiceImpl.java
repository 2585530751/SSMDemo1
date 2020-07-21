package com.neusoft.service.impl;

import com.neusoft.dao.EasybuyUserMapper;
import com.neusoft.entity.EasybuyUser;
import com.neusoft.service.UserService;
import com.neusoft.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务逻辑的实现类  实现接口
 *6t6
 */
@Service("userService")
public class UserServiceImpl  implements UserService {

    //业务逻辑层需要调用数据访问层
    @Autowired
    private EasybuyUserMapper easybuyUserMapper;

    /**
     * 根据id查询用户信息
     * @param uid
     * @return
     */
    @Override
    public EasybuyUser getUser(int uid) {
        return easybuyUserMapper.selectByPrimaryKey(uid);
    }

    @Override
    public EasybuyUser getUser(String uname, String upwd) {
        //对密码进行加密处理
        upwd= MD5Utils.MD5(upwd);
        return easybuyUserMapper.selectByUnameAndPwd(uname,upwd);
    }
}
