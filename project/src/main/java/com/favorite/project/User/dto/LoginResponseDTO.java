package com.favorite.project.User.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class LoginResponseDTO {
    private UUID uuid;
    private String name;
    private String email;


}
