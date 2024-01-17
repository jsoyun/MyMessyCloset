package com.favorite.project.User;

import com.favorite.project.User.dto.LoginForm;
import com.favorite.project.User.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    //로그인이 사용하는 LoginUserService 따로 만들기, 의존주입하면 userService안에 있는 메서드를 다 가져오는 문제.
    private final LoginUserService loginUserService;

    public User checkLoginForm(LoginForm loginForm) {
        String email = loginForm.getEmail();
        User userEmail = User.builder().email(email).build();

        String password = loginForm.getPassword();

        return loginUserService.getUserByEmail(userEmail).filter(m -> m.getPassword().equals(password)).orElse(null);

    }


}
