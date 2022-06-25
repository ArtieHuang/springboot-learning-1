package com.ari.spring.service;

import com.ari.spring.entity.User;
import com.ari.spring.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//userservice调用usermapper接口，形成条件函数。
@Service
public class UserService extends ServiceImpl<UserMapper,User> {

        public boolean saveUser(User user){
            return saveOrUpdate(user);
        }

//   @Autowired
//   private UserMapper userMapper;
}
//    public int save(User user) {
//        if (user.getId() == null) {
//            return userMapper.insert(user);
//        }//若没有id，新增
//        else {//否则更新
//            return userMapper.update(user);
//        }
//
//    }

