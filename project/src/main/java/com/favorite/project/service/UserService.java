package com.favorite.project.service;

import com.favorite.project.dto.UserDTO;
import com.favorite.project.entity.Users;
import com.favorite.project.mapper.UserMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

//    public Users getById(Long userId) {
////        return userMapper.getById(userId);
//
//    }


//    public Users getUserByEmail(UserDTO userDTO) {
//        //id 값으로 조회하고 싶었는데.. 사용자는 email 주소를 검색해보니까
//        return userMapper.getByEmail(userDTO.getEmail());
//    }

    public List<Users> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public boolean insertOneUser(UserDTO userDTO) {

        try {

            Users user = Users.builder()
                    .name(userDTO.getName())
                    .email(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .build();

            userMapper.insert(user);

            return true;


        } catch (DataAccessException dataAccessException) {
            logger.error(dataAccessException.getMessage());
            return false;

        } catch (PersistenceException persistenceException) {
            logger.error("persistenceException", persistenceException);
            return false;
        } catch (IllegalArgumentException illegalArgumentException) {
            logger.error("illegalArgumentException", illegalArgumentException);
            return false;

        }


    }


    public List<Users> select() {
        try {

            return userMapper.select();

        } catch (PersistenceException persistenceException) {
            logger.error("List<user> select(): {}", persistenceException.getMessage());
            throw new RuntimeException(persistenceException);

        }


    }


}
