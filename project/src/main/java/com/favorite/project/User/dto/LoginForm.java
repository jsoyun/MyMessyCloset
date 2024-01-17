package com.favorite.project.User.dto;

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
