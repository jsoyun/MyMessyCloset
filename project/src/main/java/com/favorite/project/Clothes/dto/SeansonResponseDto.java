package com.favorite.project.Clothes.dto;

import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class SeansonResponseDto {
    private int userClosetId;
    private int clothesId;
    private String clothesCategoryEnumTypeName;
    private int price;
    private String imgUrl;
    private LocalDate purchasedDate;


    public SeansonResponseDto toSeansonResponseDto(ClothesListDto clothesListDto) {

        return SeansonResponseDto.builder()
                .userClosetId(clothesListDto.getUserClosetId())
                .clothesId(clothesListDto.getId())
                .clothesCategoryEnumTypeName(ClothesCategoryEnumType.getClothesCategoryName(clothesListDto.getClothesCategoryEnumTypeId()))
                .price(clothesListDto.getPrice())
                .imgUrl(clothesListDto.getImg())
                .purchasedDate(clothesListDto.getPurchasedDate())
                .build();
    }

}
