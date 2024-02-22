package com.favorite.project.UserCloset.dto;

import com.favorite.project.UserCloset.domain.UserCloset;
import lombok.Builder;
import lombok.Getter;

//폼데이터를 받을 역할!
@Getter
@Builder
public class UserClosetAddDto {
    private String name;
    private String color;
    private String notes;
    private int userId;

    public UserCloset toUserClosetEntity() {

        return UserCloset.builder().name(name)
                .color(color)
                .notes(notes)
                .userId(userId).build();

    }


}
