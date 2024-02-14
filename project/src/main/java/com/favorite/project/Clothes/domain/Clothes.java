package com.favorite.project.Clothes.domain;

import com.favorite.project.Clothes.dto.ClothesResponseDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.Clothes.SeasonType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
public class Clothes {
    private ClothesCategoryEnumType clothesCategoryEnumType;
    private SeasonType seasonType;
    private int price;
    private String imgUrl;
    private LocalDate purchasedDate;

    @Setter
    private int categoryId;
    @Setter
    private int userClosetId;


    public ClothesCategoryEnumType getCategoryName() {
        return this.clothesCategoryEnumType;

    }


    public ClothesResponseDto toClothesResponseDto(Clothes clothes) {
        return ClothesResponseDto.builder().clothesCategoryType(clothes.clothesCategoryEnumType)
                .seasonType(clothes.seasonType)
                .price(clothes.price)
                .imgUrl(clothes.imgUrl)
                .purchasedDate(clothes.purchasedDate)
                .categoryId(clothes.categoryId)
                .userClosetId(clothes.userClosetId)
                .build();
    }

}
