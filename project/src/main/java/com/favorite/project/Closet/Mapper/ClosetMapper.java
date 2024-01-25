package com.favorite.project.Closet.Mapper;

import com.favorite.project.Closet.domain.UserCloset;
import com.favorite.project.User.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClosetMapper {
    //TODO: 필요한 값만 선택해서 가져올 수 있도록.dto 이용해서
//    @Select("SELECT * FROM userCloset")
//    List<UserCloset> getAllUserClosets();


    @Insert("INSERT INTO userCloset (name, color, notes,user_id) VALUES (#{UserCloset.name},#{UserCloset.color},#{UserCloset.notes},#{UserCloset.user_id})")
    boolean insertUserCloset(@Param("UserCloset") UserCloset closet);

    List<UserCloset> getAllUserClosets();

}
