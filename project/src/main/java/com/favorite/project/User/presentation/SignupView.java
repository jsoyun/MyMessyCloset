package com.favorite.project.User.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupViewController {
    @GetMapping("/")
    public String index() {
        return "/index";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }

    @GetMapping("/sign")
    public String sign() {
        return "/sign";
    }


}
