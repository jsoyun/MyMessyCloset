package com.favorite.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter

//@Entity

public class myCloset {

//    @Id
    private final int id;
    private String color;
    private String notes;
    private int clothes_id;
    private int user_id;

    //생성자
    public myCloset(int id, String color, String notes, int clothes_id,int user_id) {
        this.id = id;
        this.color = color;
        this.notes = notes;
        this.clothes_id = clothes_id;
        this.user_id = user_id;

    }

public static class Builder{
    private int id;

    public Builder id(int value){
        this.id = value;
        return this;
    }


    public myCloset build(){
        return new myCloset(this);
    }
}


    private myCloset(Builder builder){
    this.id = builder.id;
    }

    //빌더 소환
    public static Builder builder(){
    return new Builder();
    }

}
