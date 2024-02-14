package com.favorite.project.Clothes;

import lombok.Getter;

@Getter
public enum SeasonType {
    SPRING("봄"),
    SUMMER("여름"),
    FALL("가을"),
    WINTER("겨울");

    final String season;

    SeasonType(String season) {
        this.season = season;

    }
}
