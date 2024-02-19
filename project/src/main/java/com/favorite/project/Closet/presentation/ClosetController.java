package com.favorite.project.Closet.presentation;

import com.favorite.project.Closet.ClosetService;
import com.favorite.project.User.domain.User;
import com.favorite.project.Validator.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class ClosetController {

    private final ClosetService closetService;
    private final SessionManager sessionManager;

    /**
     * 로그인 되어 있어야하만 closet 추가할 수 있음
     * 세션 유무로 파악
     */

    @GetMapping("/closet")
    public String getClosetView(HttpServletRequest request, HttpServletResponse response, Model model) {

        if (sessionManager.getSession(request) == null) {
            System.out.println("sessionManager.getSession(request) = " + sessionManager.getSession(request));
            return "redirect:/";
        }
        User session = (User) sessionManager.getSession(request);
        Long id = session.getId();
        model.addAttribute("userId", id);
        return "/closet";
    }


}
