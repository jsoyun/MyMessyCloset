package com.favorite.project.User.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class LoginResponseDTO {
    private Long id;
    private String name;
    private String email;


}
