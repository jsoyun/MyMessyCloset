package com.favorite.project.Clothes;

import com.favorite.project.Clothes.Mapper.ClothesMapper;
import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.Clothes.dto.ClothesResponseDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.ClothesCategory.ClothesCategoryService;
import com.favorite.project.UserCloset.UserClosetValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    @Mock
    private UserClosetValidator closetValidator;


    @InjectMocks
    private ClothesService clothesService;

    private ClothesAddDto clothesAddDto;

    @BeforeEach
    public void setUp() {
        ClothesCategoryEnumType tops = ClothesCategoryEnumType.TOPS;
        clothesAddDto = ClothesAddDto.builder().clothesCategoryType(tops)
                .seasonType(SeasonType.SUMMER)
                .price(1000)
                .imgUrl("멋진옷.jpg")
                .purchasedDate(LocalDate.parse("2024-02-11"))
                .userClosetId(1)
                .build();
    }


    @Test
    @DisplayName("옷 추가 성공")
    public void addClothes() {

        ClothesCategoryEnumType tops = ClothesCategoryEnumType.TOPS;
        given(closetValidator.checkUserCloset(1)).willReturn(true);
        given(clothesMapper.insertClothes(any())).willReturn(true);
        //when
        ClothesResponseDto clothesResponseDto = clothesService.addClothes(clothesAddDto);
        //then
        verify(clothesMapper, times(1)).insertClothes(any());
        Assertions.assertThat(clothesResponseDto.getClothesCategoryType()).isEqualTo(tops);


    }

    @Test
    @DisplayName("유효한 옷장이 아니어서 옷 추가 실패")
    public void failedAddClothes() {
        given(closetValidator.checkUserCloset(1)).willReturn(false);
        //when
        boolean checkValidClosetResult = closetValidator.checkUserCloset(1);
        //then
        Assertions.assertThat(checkValidClosetResult).isFalse();
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> clothesService.addClothes(clothesAddDto));


    }

    @Test
    @DisplayName("세션이 없어서 실패")
    public void sessionIsNull() {

        given(closetValidator.checkUserCloset(1)).willReturn(false);
        //when
        boolean checkValidClosetResult = closetValidator.checkUserCloset(1);
        //then
        Assertions.assertThat(checkValidClosetResult).isFalse();
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> clothesService.addClothes(clothesAddDto));


    }


}

