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

/**
 * 로그인:
 * 해당하는 이메일의 비밀번호가 일치한지  확인
 * 일치하면 해당하는 유저값을 컨틀롤러에 응답
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginUserService loginUserService;


    public LoginResponseDTO checkLoginForm(LoginRequestDTO loginRequestDTO) {
        String email = loginRequestDTO.getEmail();
        User userEmail = User.builder().email(email).build();
        String password = loginRequestDTO.getPassword();

        User userByEmail = loginUserService.getUserByEmail(userEmail);
        boolean equals = userByEmail.getPassword().equals(password);
        if (equals) {
            return LoginResponseDTO.builder().uuid(userByEmail.getUuid()).name(userByEmail.getName()).email(userByEmail.getEmail()).build();

        } else {
            throw new NoSuchElementException("비밀번호가 일치하지 않습니다.");
        }


    }


}
