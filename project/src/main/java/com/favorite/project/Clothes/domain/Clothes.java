package com.favorite.project.Clothes.domain;

import com.favorite.project.Clothes.dto.ClothesInsertionResponseDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.Clothes.SeasonType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Clothes {
    private ClothesCategoryEnumType clothesCategoryEnumType;
    private SeasonType seasonType;
    private int price;
    private String imgUrl;
    private LocalDate purchasedDate;
    private int categoryId;
    private int userClosetId;


    public ClothesCategoryEnumType getCategoryName() {
        return this.clothesCategoryEnumType;

    }

    public ClothesInsertionResponseDto toClothesResponseDto(Clothes clothes) {
        return ClothesInsertionResponseDto.builder()
                .clothesCategoryType(clothes.clothesCategoryEnumType)
                .seasonType(clothes.seasonType)
                .price(clothes.price)
                .imgUrl(clothes.imgUrl)
                .purchasedDate(clothes.purchasedDate)
                .userClosetId(clothes.userClosetId)
                .build();
    }

}
