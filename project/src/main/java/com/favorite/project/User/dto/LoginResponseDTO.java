package com.favorite.project.User.dto;

import com.favorite.project.User.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class LoginResponseDTO {
    private Long id;
    private String name;
    private String email;

    public User toUser(LoginResponseDTO loginResponseDTO) {
        return User.builder()
                .id(loginResponseDTO.id)
                .email(loginResponseDTO.email)
                .name(loginResponseDTO.name)
                .build();

    }


}
