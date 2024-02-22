package com.favorite.project.UserCloset.Mapper;

import com.favorite.project.UserCloset.domain.UserCloset;
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


    @Insert("INSERT INTO userCloset (name, color, notes,user_id) VALUES (#{UserCloset.name},#{UserCloset.color},#{UserCloset.notes},#{UserCloset.userId})")
    boolean insertUserCloset(@Param("UserCloset") UserCloset closet);

    List<UserCloset> getAllUserClosets();

    @Select("SELECT EXISTS (SELECT 1 FROM UserCloset WHERE id = #{id})")
    boolean checkUserClosetById(@Param("id") int id);

    @Select("SELECT EXISTS (SELECT 1 FROM UserCloset WHERE user_id = #{id})")
    boolean checkUserById(@Param("id") Long id);

}
