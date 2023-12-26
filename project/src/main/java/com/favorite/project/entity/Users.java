package com.favorite.project.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Users {
    private int userId;
    private String email;
    private String name;
    private String password;
    private Integer userClosetId;


}