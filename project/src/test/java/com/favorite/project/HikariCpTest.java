package com.favorite.project;


import com.favorite.project.dao.ClosetDao;
import com.favorite.project.entity.Closet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

public class HikariCpTest {

    @Autowired
    private ClosetDao closetDao;



    @Test
    void save() throws SQLException,InterruptedException{
        int id = 1;
        int price = 1000;
        String category ="카테고리임다";


        //builder 패턴으로 값 지정
        Closet closet1 = Closet.builder()
                .id(id)
                .price(price)
                .category(category)
                .build();


//        closet.setColor("노랑파랑입니다");
//        closet.setNotes("단순기록");
//        closet.setSeason("겨울");
//        closet.setSize("medium");
//        closet.setBrand("엘레강스브랜드");
//        closet.setPurchase_date(LocalDate.of(2024, 1, 1));
//
//
//        Integer findCloset =
//                closetDao.find(closet);
//
//        assertThat(closet1.getId()).isEqualTo(findCloset);
        assertThat(closet1.getId()).isEqualTo(id);
        assertThat(closet1.getCategory()).isEqualTo(category);


    }

}