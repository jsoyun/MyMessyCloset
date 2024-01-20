package com.favorite.project.Closet.dto;

import com.favorite.project.Closet.domain.UserCloset;
import lombok.Builder;
import lombok.Getter;

//폼데이터를 받을 역할!
@Getter
@Builder
public class ClosetAddDto {
    private String name;
    private String color;
    private String notes;
    private int user_id;

    public UserCloset toUserClosetEntity() {

        return UserCloset.builder().name(name)
                .color(color)
                .notes(notes)
                .user_id(user_id).build();

    }


}
