package com.favorite.project.ClothesCategory.dto;

import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryAddDto {
    private ClothesCategoryEnumType clothesCategoryEnumType;

    public ClothesCategory toClothesCategory(CategoryAddDto categoryAddDto) {

        ClothesCategory clothesCategory = ClothesCategory.builder().clothesCategoryEnumType(categoryAddDto.getClothesCategoryEnumType()).build();

        return clothesCategory;
    }
}
