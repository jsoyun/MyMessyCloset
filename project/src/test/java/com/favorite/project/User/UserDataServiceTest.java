package com.favorite.project.User;


import com.favorite.project.User.domain.User;
import com.favorite.project.User.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

@SpringBootTest
public class UserDataServiceTest {


    private final UserMapper userMapper;

    @Autowired
    public UserDataServiceTest(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Test
    public void InsertUserAsNull_WithColumnShouldNotNull() {


        User user = User.builder()
                .build();

        Assertions.assertThrows(DataAccessException.class, () -> userMapper.insert(user));

    }


    @Test
    public void InsertUserAsDuplicateEmail() {


        User user = User.builder()
                .name("가나다")
                .email("test@test") //중복되는 이메일
                .password("123")
                .build();

        Assertions.assertThrows(DataAccessException.class, () -> userMapper.insert(user));

    }


}
