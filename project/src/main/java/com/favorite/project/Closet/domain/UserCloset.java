package com.favorite.project.Closet.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserCloset {
    private int id; //id값은 autoincrement로 자동으로 추가되는데 builder에서 제외하는게 좋을까?
    private String name;
    private String color;
    private String notes;
    private int user_id;


}