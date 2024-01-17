package com.favorite.project.Clothes.domain;

import lombok.Builder;

import java.util.List;

@Builder
public class Clothes {
    String name;
    String ClothesUID;
    List<String> Types;
}
