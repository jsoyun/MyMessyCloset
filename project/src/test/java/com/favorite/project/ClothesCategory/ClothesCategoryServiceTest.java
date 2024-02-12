package com.favorite.project.ClothesCategory;


import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.ClothesCategory.Mapper.CategoryMapper;
import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import com.favorite.project.ClothesCategory.dto.CategoryAddDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClothesCategoryServiceTest {

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private ClothesCategoryService clothesCategoryService;

    @Test
    @DisplayName("카테고리 추가 테스트")
    void addClothesCategoryTest() {
        CategoryAddDto categoryAddDto = CategoryAddDto.builder().clothesCategoryEnumType(ClothesCategoryEnumType.TOPS).build();
        ClothesCategory clothesCategory = ClothesCategory.builder().clothesCategoryEnumType(categoryAddDto.getClothesCategoryEnumType()).build();
        //given
        given(clothesCategoryService.addCategory(categoryAddDto)).willReturn(true);
        //when
        boolean result = categoryMapper.insertClothesCategory(clothesCategory.getClothesCategoryEnumType());
        //then
        verify(categoryMapper).insertClothesCategory(clothesCategory.getClothesCategoryEnumType());
        Assertions.assertThat(result).isTrue();


    }

    @Test
    @DisplayName("카테고리 id 가져오기")
    void getClothesCategoryIdTest() {
        ClothesAddDto clothesAddDto = ClothesAddDto.builder().clothesCategoryType(ClothesCategoryEnumType.TOPS).build();
        ClothesCategoryEnumType clothesCategoryType = clothesAddDto.getClothesCategoryType();

        //given
        given(clothesCategoryService.getClothesCategoryId(clothesCategoryType)).willReturn(1);
        //when
        int idByCategoryName = categoryMapper.selectCategoryIdByCategoryName(clothesCategoryType.name());
        //then
        verify(categoryMapper).selectCategoryIdByCategoryName(clothesCategoryType.name());
        Assertions.assertThat(idByCategoryName).isEqualTo(1);

    }


}
