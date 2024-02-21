package com.favorite.project.UserCloset.presentation;

import com.favorite.project.UserCloset.ClosetService;
import com.favorite.project.User.domain.User;
import com.favorite.project.Validator.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ClosetController {

    private final ClosetService closetService;

    /**
     * 로그인 되어 있어야하만 closet 추가할 수 있음
     * 세션 유무로 파악
     */

    @GetMapping("/closet")
    public String getClosetView(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "redirect:/";
        }
        User valueBySessionAttribute = (User) session.getAttribute(SessionConst.USER_SESSION_ID);
        Long id = valueBySessionAttribute.getId();
        model.addAttribute("userId", id);
        return "/closet";
    }


}
