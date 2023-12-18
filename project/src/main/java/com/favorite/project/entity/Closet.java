package com.favorite.project.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
//@Entity
public class Closet {

//    @Id
    private final int id, price;
    private final String  category ;
    private String color;
    private String size ;
    private String brand;
    private String season;
    private LocalDate purchase_date;
    private String notes;

    //생성자
    public Closet(int id, int price, String category) {
        this.id = id;

        this.price = price;
        this.category = category;
    }

public static class Builder{
    private int id;
    private  int price;
    private String  category ;

    public Builder id(int value){
        this.id = value;
        return this;
    }

    public Builder price(int value){
        this.price = value;
        return this;
    }

    public Builder category(String value){
        this.category = value;
        return this;
    }

    public  Closet build(){
        return new Closet(this);
    }
}


    private Closet(Builder builder){
    this.id = builder.id;
    this.price = builder.price;
    this.category = builder.category;
    }

    //빌더 소환
    public static Builder builder(){
    return new Builder();
    }

}
