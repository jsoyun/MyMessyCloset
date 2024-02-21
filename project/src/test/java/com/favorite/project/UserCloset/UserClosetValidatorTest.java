package com.favorite.project.UserCloset;

import com.favorite.project.UserCloset.Mapper.ClosetMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserClosetValidatorTest {

    @Mock
    private ClosetMapper closetMapper;

    @Test
    @DisplayName("유효한 옷장이 맞다")
    public void checkValidUserCloset() {
        //given
        given(closetMapper.checkUserClosetById(1)).willReturn(true);

        //when
        boolean result = closetMapper.checkUserClosetById(1);

        //then
        Assertions.assertThat(result).isEqualTo(true);


    }

    @Test
    @DisplayName("존재하지 않는 옷장이다!")
    public void checkUnExistUserCloset() {
        //given
        given(closetMapper.checkUserClosetById(1)).willReturn(false);

        //when
        boolean result = closetMapper.checkUserClosetById(1);

        //then
        Assertions.assertThat(result).isFalse();


    }

    @Test
    @DisplayName("로그인한 유저가 이 옷장의 주인이 맞다")
    public void checkUserBySession() {
        //given
        given(closetMapper.checkUserById(1L)).willReturn(true);

        //when
        boolean result = closetMapper.checkUserById(1L);

        //then
        Assertions.assertThat(result).isEqualTo(true);

    }

    @Test
    @DisplayName("로그인한 유저가 이 옷장의 주인이 아니다")
    public void checkUserByWrongSession() {
        //given
        given(closetMapper.checkUserById(2L)).willReturn(false);

        //when
        boolean result = closetMapper.checkUserById(2L);

        //then
        Assertions.assertThat(result).isFalse();

    }


}
