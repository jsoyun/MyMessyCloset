package com.favorite.project.Board.domain;

public enum BoardType {
    RENT("대여 게시판"),
    SALE("판매 게시판");

    private final String description;

    BoardType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
