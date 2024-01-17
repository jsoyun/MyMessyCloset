package com.favorite.project.Closet.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClosetController {

    @GetMapping("/closet")
    public String getClosetView() {
        return "/closet";
    }
}
