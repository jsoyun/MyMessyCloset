package com.favorite.project.ClothesCategory.Mapper;

import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO Clothes_category (category_name) VALUES (#{ClothesCategoryEnumType})")
    boolean insertClothesCategory(@Param("ClothesCategoryEnumType") ClothesCategoryEnumType clothesCategoryEnumType);

}
