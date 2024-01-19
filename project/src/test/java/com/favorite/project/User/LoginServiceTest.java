package com.favorite.project.User;


import com.favorite.project.User.dto.LoginForm;
import com.favorite.project.User.domain.User;
import com.favorite.project.User.LoginService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
public class LoginServiceTest {


    @Mock
    private LoginService loginService;

    private LoginForm loginForm;
    private User user;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        loginForm = LoginForm.builder().email("so@naver.com").password("1234").build();
        user = User.builder().email(loginForm.getEmail()).password(loginForm.getPassword()).build();
    }

    @Test
    @DisplayName("checkLoginForm테스트")
    public void checkLoginFormTest() {
        //given

        when(loginService.checkLoginForm(loginForm)).thenReturn(user);

        //when
        User user1 = loginService.checkLoginForm(loginForm);
        //then
        verify(loginService).checkLoginForm(loginForm);

        Assertions.assertThat(user1.getEmail()).isEqualTo("so@naver.com");
        Assertions.assertThat(user1.getPassword()).isEqualTo("1234");
    }


}
