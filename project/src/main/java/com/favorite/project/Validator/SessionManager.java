package com.favorite.project.Validator;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {
    private static final String SESSION_COOKIE_NAME = "mySessionId";
    //동시요청에 안전한 ConcurrentHashMap 사용
    //서버 재시작하면 session 정보 날라감
    //TODO: 서버 재시작해서 session 정보 날라가면 브라우저에 있는 쿠키값도 삭제
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    /***
     * 세션 생성
     *
     */

    public void createSession(Object value, HttpServletResponse response) {

        //세션 id를 생성하고 값을 세션에 저장
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        //쿠키생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);

    }

    /**
     * 세션 조회
     */
    public Object getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());

    }

    /**
     * 세션 만료
     */
    public void expire(HttpServletRequest request, HttpServletResponse response) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            System.out.println(" sessionCookie=null이 아님: " + sessionCookie);
            //서버 메모리에 담긴 세션에 저장된 쿠키값 삭제
            sessionStore.remove(sessionCookie.getValue());
            //브라우저에서 해당 쿠키 삭제
            sessionCookie.setMaxAge(0);
            response.addCookie(sessionCookie);


        }
    }

    private Cookie findCookie(HttpServletRequest request, String sessionCookieName) {
        if (request.getCookies() == null) {
            return null;
        }

        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(sessionCookieName))
                .findAny()
                .orElse(null);
    }


}
