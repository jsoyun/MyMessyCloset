package com.favorite.project.User;

import com.favorite.project.User.dto.LoginRequestDTO;
import com.favorite.project.User.domain.User;
import com.favorite.project.User.dto.LoginResponseDTO;
import com.favorite.project.User.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    //로그인이 사용하는 LoginUserService 따로 만들기, 의존주입하면 userService안에 있는 메서드를 다 가져오는 문제.
    private final LoginUserService loginUserService;

    public LoginResponseDTO checkLoginForm(LoginRequestDTO loginRequestDTO) {
        String email = loginRequestDTO.getEmail();
        User userEmail = User.builder().email(email).build();
        String password = loginRequestDTO.getPassword();

        Optional<User> userByEmail = loginUserService.getUserByEmail(userEmail);
        User user = userByEmail.filter(m -> m.getPassword().equals(password)).orElseThrow(() -> new NoSuchElementException("User not found"));
        LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder().id(user.getUserId()).name(user.getName()).email(user.getEmail()).build();

        return loginResponseDTO;


    }


}
