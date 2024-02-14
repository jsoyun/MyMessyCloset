package com.favorite.project.ClothesCategory;

import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import lombok.Getter;

@Getter
public enum ClothesCategoryEnumType {
    TOPS("상의"),
    PANTS("바지"),
    OUTERWEAR("외투"),
    ACTIVE("기능성옷");

    private String title;

    ClothesCategoryEnumType(String title) {
        this.title = title;
    }


}
