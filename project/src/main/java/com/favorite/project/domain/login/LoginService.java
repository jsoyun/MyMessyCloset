package com.favorite.project.domain.login;

import com.favorite.project.controller.dto.login.LoginForm;
import com.favorite.project.domain.UserService;
import com.favorite.project.domain.entity.User;
import com.favorite.project.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserService userService;
//    private final UserMapper userMapper;

    public User checkLoginForm(LoginForm loginForm) {
        String email = loginForm.getEmail();
        User userEmail = User.builder().email(email).build();

        String password = loginForm.getPassword();

        return userService.getUserByEmail(userEmail).filter(m -> m.getPassword().equals(password)).orElse(null);
//        boolean result = userMapper.getByEmail(email).getPassword().equals(password);
//        if (result) {
//            return userMapper.getByEmail(email);
//        } else {
//            return User.builder().build();
//        }
    }


}
