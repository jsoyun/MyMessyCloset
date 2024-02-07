package com.favorite.project.User.dto;

import com.favorite.project.User.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private String name;
    private String email;
    private String password;


    public UserDTO toUserDTO(User user) {
        return UserDTO.builder().name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword()).build();
    }


}
