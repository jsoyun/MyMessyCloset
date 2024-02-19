package com.favorite.project.Validator;

import com.favorite.project.User.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class SessionManagerTest {

    @Test
    void sessionTest() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        User user = User.builder()
                .id(1L)
                .email("so")
                .name("이소윤")
                .password("123").build();

        String sesstionId = "userSessionId";

        //세션 생성
        HttpSession session = request.getSession();
        session.setAttribute(sesstionId, user);
        //서버가 응답으로 쿠키 추가
        //TODO:Check: 실제 로직에서는 자동으로 생기던데? 맞나? JSESSIONID
        response.addCookie(new Cookie("JSESSIONID", sesstionId));

        //요청
        HttpSession getSession = request.getSession(false);
        User userBySesstionAttribute = (User) getSession.getAttribute(sesstionId);
        Long id = userBySesstionAttribute.getId();
        String name = userBySesstionAttribute.getName();

        //세션 조회
        Assertions.assertThat(id).isEqualTo(1L);
        Assertions.assertThat(name).isEqualTo("이소윤");

        //세션 만료
        getSession.invalidate();
        Assertions.assertThat(request.getSession(false)).isNull();

    }


}
