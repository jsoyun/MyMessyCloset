package com.favorite.project.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private Long userId;
    private String email;
    private String name;
    private String password;
    private Integer userClosetId;


}