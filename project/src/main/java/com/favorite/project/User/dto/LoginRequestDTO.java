package com.favorite.project.User.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class LoginRequestDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
