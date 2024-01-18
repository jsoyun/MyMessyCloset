package com.favorite.project.Closet.presentation;

import com.favorite.project.Closet.ClosetService;
import com.favorite.project.Closet.domain.UserCloset;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClosetController {

    private final ClosetService closetService;

    //TODO: 로그인 되어 있어야하만 closet 추가할 수 있음
    //TODO: 세션 유무로 파악
    //TODO: userId를 넘겨줘야함!
    @GetMapping("/closet/{user_id}")
    public String getClosetView(@PathVariable @CookieValue(name = "user_id", required = false) Long user_id, Model model) {

        if (user_id == null) {
            return "redirect:/";

        }

        model.addAttribute("User", user_id);


        return "/closet";
    }

    @GetMapping("/closet")
    public String getAllCloset() {
        closetService.getAllUserClosets();
        return "/closetList";

    }


}
