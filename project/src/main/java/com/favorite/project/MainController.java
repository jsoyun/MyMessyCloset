package com.favorite.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller

public class MainController {
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
