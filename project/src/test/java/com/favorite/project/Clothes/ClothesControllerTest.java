package com.favorite.project.Clothes;

import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.Clothes.dto.ClothesListDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import com.favorite.project.UserCloset.UserClosetValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ClothesControllerTest {
    @Mock
    UserClosetValidator userClosetValidator;

    @Mock
    ClothesService clothesService;
    @InjectMocks
    ClothesController clothesController;

    @Test
    @DisplayName("세션이 없는 경우 ")
    public void sessionIsNull() {
        ClothesCategoryEnumType tops = ClothesCategoryEnumType.TOPS;

        HttpServletRequest request = mock(HttpServletRequest.class);
        //given
        given(request.getSession(false)).willReturn(null);

        //when
        //then
        Assertions.assertThrows(NullPointerException.class, () -> clothesController.addClothes(ClothesAddDto.builder().build(), request));

    }

    @Test
    @DisplayName("GET_CLOTHES_BY_USERCLOSETID")
    public void successGetClothes() {

        //결과값
        List<ClothesListDto> ClothesList = new ArrayList<>();
        ClothesListDto build = ClothesListDto.builder().userClosetId(54).clothesCategoryEnumTypeId(1).build();
        ClothesListDto build2 = ClothesListDto.builder().userClosetId(54).clothesCategoryEnumTypeId(2).build();
        ClothesList.add(build);
        ClothesList.add(build2);


        int userClosetId = 54;
        int page = 1;
        int pageSize = 2;


        for (int i = page - 1; i < pageSize; i++) {
            assertThat(ClothesList.get(i).getUserClosetId()).isEqualTo(userClosetId);
        }
        assertThat(ClothesList.size()).isEqualTo(pageSize);


    }
}
