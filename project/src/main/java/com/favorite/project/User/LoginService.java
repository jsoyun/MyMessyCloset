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
    
    private final LoginUserService loginUserService;

    public LoginResponseDTO checkLoginForm(LoginRequestDTO loginRequestDTO) {
        String email = loginRequestDTO.getEmail();
        User userEmail = User.builder().email(email).build();
        String password = loginRequestDTO.getPassword();

        //TODO: 이메일 조회 - 성공, 비밀번호 - 실패 : 실패 요인 담기
        Optional<User> userByEmail = loginUserService.getUserByEmail(userEmail);
        User user = userByEmail.filter(m -> m.getPassword().equals(password)).orElseThrow(() -> new NoSuchElementException("User not found"));
        LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder().id(user.getUserId()).name(user.getName()).email(user.getEmail()).build();

        return loginResponseDTO;


    }


}
