package com.favorite.project.ClothesCategory.dto;

import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class CategoryAddDto {
    @NotNull
    private ClothesCategoryEnumType clothesCategoryEnumType;

    public ClothesCategory toClothesCategory(CategoryAddDto categoryAddDto) {

        return ClothesCategory.builder()
                .clothesCategoryEnumType(categoryAddDto.getClothesCategoryEnumType())
                .build();
    }
}
