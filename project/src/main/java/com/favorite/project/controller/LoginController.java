package com.favorite.project.controller;

import com.favorite.project.controller.dto.login.LoginForm;
import com.favorite.project.domain.entity.User;
import com.favorite.project.domain.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
        log.info("[GetMapping/loginForm]");
        return "/loginForm";

    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("bindingResult.hasErrors-[GetMapping/login]");
            return "/loginForm";

        }

        User user = loginService.checkLoginForm(loginForm);

        if (user == null) {

            bindingResult.reject("loginFail", "일치하는 회원정보가 없습니다. 다시 시도해주세요");
            return "/loginForm";

        }

        return "redirect:/";


    }
}
