package com.favorite.project.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private String name;
    private String email;
    private String password;
    //user 로그인, 로그아웃 상태 - 이런 세션은 어떻게 관리하지..?
    private String state;


}
