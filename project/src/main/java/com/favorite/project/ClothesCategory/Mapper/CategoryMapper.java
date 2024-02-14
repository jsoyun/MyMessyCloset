package com.favorite.project.ClothesCategory.Mapper;

import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO Clothes_category (category_name) VALUES (#{ClothesCategoryEnumType})")
    boolean insertClothesCategory(@Param("ClothesCategoryEnumType") ClothesCategoryEnumType clothesCategoryEnumType);

    @Select("SELECT id FROM messyCloset.Clothes_category WHERE category_name = #{categoryName}")
    int selectCategoryIdByCategoryName(@Param("categoryName") String categoryName);

}
