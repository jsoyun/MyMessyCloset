package com.favorite.project.Clothes;

import com.favorite.project.Clothes.Mapper.ClothesMapper;
import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.Clothes.dto.ClothesResponseDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.ClothesCategoryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClothesServiceTest {
    @Mock
    private ClothesMapper clothesMapper;
    @Mock
    private ClothesCategoryService clothesCategoryService;

    @InjectMocks
    private ClothesService clothesService;


    @Test
    @DisplayName("옷 추가 성공")
    public void addClothes() {

        ClothesCategoryEnumType tops = ClothesCategoryEnumType.TOPS;
        ClothesAddDto clothesAddDto = ClothesAddDto.builder().clothesCategoryType(tops)
                .seasonType(SeasonType.SUMMER)
                .price(1000)
                .imgUrl("멋진옷.jpg")
                .purchasedDate(LocalDate.parse("2024-02-11"))
                .userClosetId(1)
                .build();

        given(clothesMapper.insertClothes(any())).willReturn(true);
        //when
        ClothesResponseDto clothesResponseDto = clothesService.addClothes(clothesAddDto);
        //then
        verify(clothesMapper, times(1)).insertClothes(any());
        Assertions.assertThat(clothesResponseDto.getClothesCategoryType()).isEqualTo(tops);


    }


}

