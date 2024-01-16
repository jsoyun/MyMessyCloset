package com.favorite.project.mapper;

import com.favorite.project.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM Users")
    List<User> getAllUsers();

    @Select("SELECT * FROM Users WHERE user_id = #{id}")
    User getById(@Param("userId") Long userID);

    @Select("SELECT * FROM Users WHERE email = #{email}")
    User getByEmail(@Param("email") String email);

    @Insert("INSERT INTO Users (email, name, password) VALUES(#{user.email} , #{user.name}, #{user.password})")
    boolean insert(@Param("user") User users);


    //xml 사용하고 싶은데 안됨.
    List<User> select();

}
