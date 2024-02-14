package com.favorite.project.Clothes;

import com.favorite.project.Clothes.Mapper.ClothesMapper;
import com.favorite.project.Clothes.domain.Clothes;
import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.Clothes.dto.ClothesResponseDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.ClothesCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesMapper clothesMapper;

    private final ClothesCategoryService clothesCategoryService;

    public ClothesResponseDto addClothes(ClothesAddDto clothesAddDto) {
        Clothes clothes = clothesAddDto.toClothes(clothesAddDto);
        ClothesCategoryEnumType categoryEnumType = clothes.getCategoryName();
        int clothesCategoryId = clothesCategoryService.getClothesCategoryId(categoryEnumType);
        clothes.setCategoryId(clothesCategoryId);
        boolean result = clothesMapper.insertClothes(clothes);
        ClothesResponseDto clothesResponseDto;
        if (result) {
            clothesResponseDto = clothes.toClothesResponseDto(clothes);
        } else {
            throw new PersistenceException("옷 저장에 실패했습니다.");

        }


        return clothesResponseDto;


    }


}
