package com.favorite.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Users {
    //key가 될 id 어노테이션
    //@GeneratedValue 해당 칼럼은 자동으로 작성되는 auto_increment 기능으로 추가
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String username;

}
