package com.favorite.project.Clothes;

import com.favorite.project.Clothes.dto.ClothesAddDto;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

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
}
