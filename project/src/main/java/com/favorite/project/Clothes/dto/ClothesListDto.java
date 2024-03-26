package com.favorite.project.Clothes.dto;

import com.favorite.project.Clothes.SeasonType;
import com.favorite.project.Clothes.domain.Clothes;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class ClothesListDto {
    private int id;
    private int userClosetId;
    private int clothesCategoryEnumTypeId;
    private int price;
    private String img;
    private LocalDate purchasedDate;
    private SeasonType season;
    

}
