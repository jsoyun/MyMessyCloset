package com.favorite.project.Clothes.dto;

import com.favorite.project.Clothes.SeasonType;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class UserClosetResponseDto {
    private int clothesId;
    private String clothesCategoryEnumTypeName;
    private SeasonType seasonType;
    private int price;
    private String imgUrl;
    private LocalDate purchasedDate;

    public UserClosetResponseDto toUserClosetIdRequestDto(ClothesListDto clothesListDto) {

        return UserClosetResponseDto.builder()
                .clothesId(clothesListDto.getId())
                .clothesCategoryEnumTypeName(ClothesCategoryEnumType.getClothesCategoryName(clothesListDto.getClothesCategoryEnumTypeId()))
                .seasonType(clothesListDto.getSeason())
                .price(clothesListDto.getPrice())
                .imgUrl(clothesListDto.getImg())
                .purchasedDate(clothesListDto.getPurchasedDate())
                .build();
    }


}
