package com.favorite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//현재 사용하지 않고 있음
//TODO: 클라이언트와 컨트롤러의 데이터 주고답을 때 사용 (UI 정보 등 클라이언트에서 필요한 데이터필드 관리)
public class UserDataDto {
    private String name;
    private int age;

}
