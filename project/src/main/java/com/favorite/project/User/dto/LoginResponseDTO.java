package com.favorite.project.User.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class LoginResponseDTO {
    private Long id;
    private String name;
    private String email;


}
