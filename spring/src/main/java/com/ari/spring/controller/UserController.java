package com.ari.spring.controller;

import com.ari.spring.entity.User;
import com.ari.spring.mapper.UserMapper;

import com.ari.spring.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//这一层是集中了所有的函数
//选择路径
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    //增加或者更新
    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }


    //查询
    @GetMapping
    public List<User> findAll() {
        List<User> all= userMapper.findAll();
        return all;
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteByID(id);
    }



    //分页查询
    @GetMapping("/page")            //接口路径，requestparam接受page
    public Map<String,Object> findPage(@RequestParam Integer pageNumber,
                                       @RequestParam Integer pageSize,
                                       @RequestParam String username) {

        pageNumber = (pageNumber-1) * pageSize;
        List<User> data = userMapper.selectPage(pageNumber,pageSize,username);
        Integer total=userMapper.countTotal(username);
        Map<String,Object> res =new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    
}


