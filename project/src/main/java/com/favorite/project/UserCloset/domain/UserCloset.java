package com.favorite.project.UserCloset.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
// 선언한 필드값과 매퍼가 똑같이 있으면 데이터 가져와짐(선언한 필드값 다 있어야함)
@NoArgsConstructor
@AllArgsConstructor
//선언한 필드와 매퍼가 다를경우에는 위 두 어노테이션이 선언되면 데이터 가져와지믄데 매퍼에 있는 필드값과 상관없이 여기 선언된 필드값 다 가져와짐
public class UserCloset {
    private int id;
    private String name;
    private String color;
    private String notes;
    private int userId;


}