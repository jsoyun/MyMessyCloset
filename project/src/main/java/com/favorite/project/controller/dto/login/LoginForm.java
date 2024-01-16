package com.favorite.project.controller.dto.login;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
public class LoginForm {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

}
