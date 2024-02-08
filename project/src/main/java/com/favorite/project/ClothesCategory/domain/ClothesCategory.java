package com.favorite.project.ClothesCategory.domain;

import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClothesCategory {
    private ClothesCategoryEnumType clothesCategoryEnumType;

}
