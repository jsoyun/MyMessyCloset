package com.favorite.project;


import com.favorite.project.dao.ClosetDao;
import com.favorite.project.entity.UserCloset;
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
    void save() throws SQLException, InterruptedException {
        int id = 1;
        int price = 1000;
        String category = "카테고리임다";


        //builder 패턴으로 값 지정
        UserCloset closet1 = UserCloset.builder()
                .id(id)
                .build();

        assertThat(closet1.getId()).isEqualTo(id);


    }

}