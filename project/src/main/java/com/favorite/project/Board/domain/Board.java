package com.favorite.project.Board.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Board {
    private LocalDateTime createdAt;
    private BoardType boardType;
    private int clothesId;
    private double price;
    private int rentalHours;
    private String content;
    private String imageUrl;
    private String location;
    private BoardStatus status;

}
