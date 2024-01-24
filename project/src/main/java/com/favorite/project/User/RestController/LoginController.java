package com.favorite.project.User.RestController;

import com.favorite.project.User.LoginService;
import com.favorite.project.User.dto.LoginRequestDTO;
import com.favorite.project.User.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {

        LoginResponseDTO loginResponseDTO = loginService.checkLoginForm(loginRequestDTO);
        return ResponseEntity.ok(loginResponseDTO);


//TODO: 일치하는 회원정보가 없을 때 메인화면으로 리다이렉트


    }
}
