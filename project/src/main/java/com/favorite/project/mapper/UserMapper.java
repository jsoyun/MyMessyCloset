package com.favorite.project.mapper;

import com.favorite.project.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM Users")
    List<Users> getAllUsers();

    @Select("SELECT * FROM Users WHERE user_id = #{id}")
    Users getById(@Param("userId") Long userID);

    @Select("SELECT * FROM Users WHERE email = #{email}")
    Users getByEmail(@Param("email") String email);

    @Insert("INSERT INTO Users (email, name, password) VALUES(#{user.email} , #{user.name}, #{user.password})")
    boolean insert(@Param("user") Users users);


    //xml 사용하고 싶은데 안됨.
    List<Users> select();

}
