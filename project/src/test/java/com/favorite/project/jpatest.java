package com.favorite.project;

import com.favorite.project.entity.Users;
import com.favorite.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
//얘가 뭐지?
@Slf4j
public class jpatest {
    @Autowired
            //인터페이스
    UserRepository userRepository;


    @BeforeEach
    void insertTestData(){
        Users user = new Users();
        user.setUsername("이소윤");
        userRepository.save(user);

        user = new Users();
        user.setUsername("최우주");
        userRepository.save(user);


        user = new Users();
        user.setUsername("kim lelele");
        userRepository.save(user);


        user = new Users();
        user.setUsername("kim laadadele");
        userRepository.save(user);
    }

    @Test
    void findAllTest(){
        System.out.println("userRepository findAllTest = " + userRepository);
        List<Users> usersList = userRepository.findAll();
        for (Users u : usersList) log.info("[FindAll]:" + u.getID()
        + " | " + u.getUsername());
    }

    @Test
    void find2ByNameTest(){
        //Like 검색으로 2개만 값을 가져오는 내가 작성했던 명령을 실행해보기
        List<Users> usersList =
                userRepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
        for (Users u : usersList) log.info("[FindSome]:" + u.getID() + "|"
        + u.getUsername());
    }



}
