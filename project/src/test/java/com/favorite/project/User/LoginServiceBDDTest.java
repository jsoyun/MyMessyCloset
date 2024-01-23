package com.favorite.project.User;

import com.favorite.project.User.domain.User;
import com.favorite.project.User.dto.LoginForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

public class LoginServiceBDDTest {

    @Mock
    private LoginUserService loginUserService;
    @InjectMocks
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
    void checkLoginFormTest() {
        //given
        //loginUserService가 email에 맞는 user값을 반환했다고 가정하면
        given(loginUserService.getUserByEmail(any(User.class))).willReturn(Optional.of(user));

        //when
        //checkLoginForm 를 호출했을 때
        Optional<User> result = loginService.checkLoginForm(loginForm);

        //then
        //값이 있고 이메일과 비밀번호도 같아야한다.
        assertThat(result).isNotNull();
        assertThat(result.get().getEmail().equals("so@naver.com"));
        assertThat(result.get().getPassword().equals("1234"));

        then(loginUserService).should().getUserByEmail(any(User.class));

    }


}
