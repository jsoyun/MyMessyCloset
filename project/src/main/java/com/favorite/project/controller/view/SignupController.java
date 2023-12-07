package com.favorite.project.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class SignupController {
    @GetMapping("/index")
    public String index(){
        return "/index";
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
    @GetMapping("/sign")
    public String sign(){
        return "/sign";
    }
}
