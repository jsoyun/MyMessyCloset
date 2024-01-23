package com.favorite.project.User.presentation;

import com.favorite.project.User.dto.LoginRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class LoginView {
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginRequestDTO loginForm) {
        log.info("[GetMapping/loginForm]");
        return "/loginForm";

    }
}
