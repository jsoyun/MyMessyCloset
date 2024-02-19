package com.favorite.project.User.RestController;

import com.favorite.project.User.LoginService;
import com.favorite.project.User.domain.User;
import com.favorite.project.User.dto.LoginRequestDTO;
import com.favorite.project.User.dto.LoginResponseDTO;
import com.favorite.project.Validator.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO, HttpServletResponse response) {

        LoginResponseDTO loginResponseDTO = loginService.checkLoginForm(loginRequestDTO);
        //로그인 성공시 sessionId 생성 (password는 없음)
        User user = loginResponseDTO.toUser(loginResponseDTO);
        sessionManager.createSession(user, response);
        return ResponseEntity.ok(loginResponseDTO);


//TODO: 일치하는 회원정보가 없을 때 메인화면으로 리다이렉트

    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logout = ");
        sessionManager.expire(request, response);
        return new ModelAndView("redirect:/");


    }
}
