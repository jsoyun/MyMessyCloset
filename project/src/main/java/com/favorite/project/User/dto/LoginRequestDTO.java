package com.favorite.project.User.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Builder
@Getter
public class LoginForm {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
