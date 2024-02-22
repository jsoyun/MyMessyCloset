package com.favorite.project.Board.domain;

import lombok.Getter;

@Getter
public enum BoardStatus {

    AVAILABLE("이용가능"),
    RESERVED("예약됨"),
    SOLD("판매완료"),
    RENTED("대여중");

    private final String description;

    BoardStatus(String description) {
        this.description = description;
    }


}
