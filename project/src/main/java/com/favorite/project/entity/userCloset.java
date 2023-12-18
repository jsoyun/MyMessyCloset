package com.favorite.project.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class userCloset {
    private int id ;
    private String color ;
    private String notes;
    private int clothes_id ;
    private int user_id;

}
