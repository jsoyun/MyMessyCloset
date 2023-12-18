package com.favorite.project;


import com.favorite.project.dao.ClosetDao;
import com.favorite.project.entity.UserCloset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class HikariCpTest {

    @Autowired
    private ClosetDao closetDao;



    @Test
    void save() throws SQLException,InterruptedException{
//        int id = 1;
        int user_id = 1;

        System.out.println("closetDao.getUserClosetCount(전) = " + closetDao.getUserClosetCount());


        //builder 패턴으로 값 지정
        UserCloset myCloset1 = UserCloset.builder()
                .user_id(user_id)
                .build();

        closetDao.addCloset(myCloset1);


        System.out.println("myCloset1.getId = " + myCloset1.getId());
        System.out.println("myCloset1.getUser_id() = " + myCloset1.getUser_id());
        System.out.println("closetDao.getUserClosetCount(후) = " + closetDao.getUserClosetCount());

//
//        assertThat(myCloset1.getId()).isEqualTo(id);



    }


//    @Test
//    void usersBuilder(){
//        //
//        Users user1 = Users.builder()
//                .user_id(1)
//                .email("user@fasdfadf.com")
//                .name("홍길동")
//                .password("1234")
//                .userCloset_id(1)
//                .build();
//
//        System.out.println("user1.getName() = " + user1.getName());
//
//    }

}