package com.ari.spring.mapper;

import com.ari.spring.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {



    @Select("SELECT * FROM sys_user")
    List<User> findAll();

    @Insert("INSERT into sys_user(username,password,nickname,email,phone,address)" +
            " VALUES(#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

    int update(User user);

    @Select("select * from sys_user where username like concat('%', #{username}, '%') limit #{pageNumber}, #{pageSize}")
    List<User> selectPage(Integer pageNumber,Integer pageSize,String username);

    @Select("select count(*) from sys_user where username like concat('%', #{username}, '%')")
    Integer countTotal(String username);




    @Delete("delete from sys_user where id = #{id}")
    Integer deleteByID(@Param("id")Integer id);

}
