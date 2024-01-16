package com.favorite.project.domain.login;

import com.favorite.project.controller.dto.login.LoginForm;
import com.favorite.project.domain.UserService;
import com.favorite.project.domain.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserService userService;

    public User checkLoginForm(LoginForm loginForm) {
        String email = loginForm.getEmail();
        User userEmail = User.builder().email(email).build();

        String password = loginForm.getPassword();

        return userService.getUserByEmail(userEmail).filter(m -> m.getPassword().equals(password)).orElse(null);

    }


}
