package com.favorite.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Closet {
    @Id
    private int id;
    private String category;
    private String color;
    private String size ; //enum으로 바꾸기
    private String brand;
    private String season;
    private LocalDate purchase_date;
    private int price;
    private String notes;

}
