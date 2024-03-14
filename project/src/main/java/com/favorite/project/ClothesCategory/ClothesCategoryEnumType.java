package com.favorite.project.ClothesCategory;

import lombok.Getter;

@Getter
public enum ClothesCategoryEnumType {
    TOPS(1, "상의"),
    PANTS(3, "하의"),
    OUTERWEAR(4, "겉옷"),
    ACTIVE(9, "활동복");

    private final int clothesCategoryId;
    private final String clothesCategoryName;


    ClothesCategoryEnumType(int clothesCategoryId, String clothesCategoryName) {
        this.clothesCategoryId = clothesCategoryId;
        this.clothesCategoryName = clothesCategoryName;
    }

    public static String getClothesCategoryName(int clothesCategoryId) {
        for (ClothesCategoryEnumType type : values()) {
            if (type.clothesCategoryId == clothesCategoryId) {
                return type.clothesCategoryName;
            }

        }
        return null;
    }

}
