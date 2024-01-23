package com.favorite.project.User;

import com.favorite.project.User.dto.LoginForm;
import com.favorite.project.User.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    //TODO: form으로 하던 json으로

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
        log.info("[GetMapping/loginForm]");
        return "/loginForm";

    }


    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.error("bindingResult.hasErrors-[GetMapping/login]");
            return "/loginForm";

        }

        Optional<User> user = loginService.checkLoginForm(loginForm);

        if (user.isEmpty()) {

            bindingResult.reject("loginFail", "일치하는 회원정보가 없습니다. 다시 시도해주세요");
            return "/loginForm";

        }

        //Cookie
        Cookie idCookie = new Cookie("user_id", String.valueOf(user.get().getUserId()));
        response.addCookie(idCookie);


        redirectAttributes.addAttribute("user_id", user.get().getUserId());

        return "redirect:/closet/{user_id}";


    }
}
