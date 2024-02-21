package com.favorite.project.Clothes;

import com.favorite.project.Clothes.Mapper.ClothesMapper;
import com.favorite.project.Clothes.domain.Clothes;
import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.Clothes.dto.ClothesResponseDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.ClothesCategoryService;
import com.favorite.project.UserCloset.UserClosetValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesMapper clothesMapper;
    private final UserClosetValidator closetValidator;

    private final ClothesCategoryService clothesCategoryService;

    public ClothesResponseDto addClothes(ClothesAddDto clothesAddDto) {
        Clothes clothes = clothesAddDto.toClothes(clothesAddDto);
        boolean checkValidClosetResult = checkValidCloset(clothes);

        if (checkValidClosetResult) {

            ClothesCategoryEnumType categoryEnumType = clothes.getCategoryName();
            int clothesCategoryId = clothesCategoryService.getClothesCategoryId(categoryEnumType);
            clothes.setCategoryId(clothesCategoryId);
            clothesMapper.insertClothes(clothes);
            return clothes.toClothesResponseDto(clothes);

        } else {
            throw new IllegalArgumentException("유효한 옷장이 아닙니다");

        }


    }

    public boolean checkValidCloset(Clothes clothes) {

        return closetValidator.checkUserCloset(clothes.getUserClosetId());
    }


}
