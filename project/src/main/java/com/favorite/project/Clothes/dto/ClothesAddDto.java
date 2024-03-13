package com.favorite.project.Clothes.dto;

import com.favorite.project.Clothes.domain.Clothes;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.Clothes.SeasonType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class ClothesAddDto {
    private ClothesCategoryEnumType clothesCategoryType;
    private SeasonType seasonType;
    private int price;
    private String imgUrl;
    private LocalDate purchasedDate;
    private int userClosetId;


    public Clothes toClothes(ClothesAddDto clothesAddDto) {
        return Clothes.builder().clothesCategoryEnumType(clothesAddDto.clothesCategoryType)
                .seasonType(clothesAddDto.seasonType)
                .price(clothesAddDto.price)
                .imgUrl(clothesAddDto.imgUrl)
                .purchasedDate(clothesAddDto.purchasedDate)
                .categoryId(clothesCategoryType.getClothesCategoryId())
                .userClosetId(clothesAddDto.userClosetId)
                .build();
    }


}
