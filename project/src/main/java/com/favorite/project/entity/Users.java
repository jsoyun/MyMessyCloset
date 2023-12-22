package com.favorite.project.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Users {
    private int user_id;
    private String email;
    private String name;
    private String password;
    private int userCloset_id;
}