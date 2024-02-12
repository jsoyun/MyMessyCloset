package com.favorite.project.Clothes.Mapper;

import com.favorite.project.Clothes.domain.Clothes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClothesMapper {
    @Insert("INSERT INTO Clothes (clothes_category_id,season, price,img,purchased_date,userCloset_id) VALUES (#{Clothes.categoryId},#{Clothes.seasonType},#{Clothes.price},#{Clothes.imgUrl},#{Clothes.purchasedDate},#{Clothes.userClosetId})")
    boolean insertClothes(@Param("Clothes") Clothes clothes);


}
