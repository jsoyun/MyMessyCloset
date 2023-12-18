package com.favorite.project.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClosetPageController {
    @GetMapping("/closet")
    public String closet(){
        return "/closet";
    }


}
