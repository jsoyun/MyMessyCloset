package com.favorite.project.User;


import com.favorite.project.User.dto.LoginRequestDTO;
import com.favorite.project.User.domain.User;
import com.favorite.project.User.dto.LoginResponseDTO;
import com.favorite.project.User.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class LoginServiceTest {


    @Mock
    private LoginUserService loginUserService;
    @InjectMocks
    private LoginService loginService;

    private LoginRequestDTO loginForm;
    private User user;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        loginForm = LoginRequestDTO.builder().email("so@naver.com").password("1234").build();
        user = User.builder().email(loginForm.getEmail()).password(loginForm.getPassword()).build();
    }

    @Test
    @DisplayName("checkLoginForm메서드 : 유저의 이메일이 맞고 이메일의 비밀번호도 맞다")
    void checkLoginFormTest() {
        //given
        //loginUserService가 email에 맞는 user값을 반환했다고 가정하면
        when(loginUserService.getUserByEmail(any())).thenReturn(user);

        //when
        //checkLoginForm 를 호출했을 때
        LoginResponseDTO loginResponseDTO = loginService.checkLoginForm(loginForm);

        //then
        //값이 있고 이메일같다.
        assertThat(loginResponseDTO).isNotNull();
        assertThat(loginResponseDTO.getEmail().equals("so@naver.com"));


    }

    @Test
    @DisplayName("이메일에 해당하는 유저는 있지만 비밀번호가 일치하지 않는다")
    void uncheckLoginFormTest() {

        //given
        User user1 = User.builder().email("test@example.com").password("123").build();
        when(loginUserService.getUserByEmail(any())).thenReturn(user1); // 무조건 유저 객체 반환


//         When: 특정 메서드를 호출 () -> 메서드 호출하면
//         Then: 예외가 발생하는지 확인 NoSuchElementException이 나온다.
        assertThrows(NoSuchElementException.class, () ->
                loginService.checkLoginForm(loginForm)

        );


    }


}
