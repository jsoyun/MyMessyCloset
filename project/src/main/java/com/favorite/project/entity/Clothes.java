package com.favorite.project.entity;

import lombok.Builder;

import java.util.List;

@Builder
public class Clothes {
    String name;
    String ClothesUID;
    List<String> Types;
}
