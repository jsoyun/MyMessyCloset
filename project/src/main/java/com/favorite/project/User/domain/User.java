package com.favorite.project.User.domain;

import com.favorite.project.User.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class User {
    private UUID uuid;
    private String email;
    private String name;
    private String password;

    public User toUser(UserDTO userDTO) {
        User user = User.builder().uuid(makeUUID()).email(userDTO.getEmail())
                .name(userDTO.getName())
                .password(userDTO.getPassword()).build();

        return user;

    }

    private UUID makeUUID() {
        UUID newUUID = UUID.randomUUID();
        return newUUID;

    }


}