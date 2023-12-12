package com.favorite.project;

import com.favorite.project.dao.ClosetDao;
import com.favorite.project.entity.Closet;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class HikariCpTest {

    @Autowired
    private  ClosetDao closetDao;
    @BeforeEach
    void connectHikari(){
        //커넥션 풀링
        HikariDataSource dataSource =
                new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/messyCloset");
        dataSource.setUsername("root");
        dataSource.setPassword("1517");
        closetDao = new ClosetDao(dataSource);

    }

    @Test
    void save() throws SQLException,InterruptedException{
        //create
        Closet closet = new Closet();
        closet.setId(10);
        closet.setColor("노랑파랑입니다");
        closet.setNotes("단순기록");
        closet.setPrice(100);
        closet.setCategory("카테고리요");
        closet.setSeason("겨울");
        closet.setSize("medium");
        closet.setBrand("엘레강스브랜드");
        closet.setPurchase_date(LocalDate.of(2024, 1, 1));

        closetDao.addCloset(closet);

        Integer findCloset =
                closetDao.find(closet);

        assertThat(closet.getId()).isEqualTo(findCloset);


    }

}
