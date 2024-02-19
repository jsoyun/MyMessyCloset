package com.favorite.project.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//유저를 확인!!
@Controller
public class SessionHandler {
    @GetMapping("/storeData")
    public String storeDataInSession(HttpServletRequest request) {
        //세션을 가져옴
        HttpSession session = request.getSession();
        //세션에 데이터 저장
        session.setAttribute("username", "exambpleadfadf");
        return "session";
    }

    @GetMapping("/retrieveData")
    public String retrieveDataFromSession(HttpServletRequest request) {
        //세션을 가져옴
        HttpSession session = request.getSession();
        //세션에서 데이터 가져오기
        String username = (String) session.getAttribute("username");
        System.out.println("Username from session: " + username);
        return "session";
    }

    @GetMapping("/removeSession")
    public String removeSession(HttpServletRequest request, HttpServletResponse response) {
        //세션을 가져옴
        HttpSession session = request.getSession();
        //세션에서 데이터 가져오기
        session.removeAttribute("username");

        //쿠키 삭제
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("cookie = " + cookie);
                //요청한 쿠키 ID를 입력해야할듯
                if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }

        }


        return "session";

    }


}
