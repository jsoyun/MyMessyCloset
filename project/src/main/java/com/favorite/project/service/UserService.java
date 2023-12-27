package com.favorite.project.service;

import com.favorite.project.dto.UserDTO;
import com.favorite.project.entity.Users;
import com.favorite.project.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
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
        //TODO: 예외처리
        //DTO를 entity로 변환
        Users user = Users.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();

        userMapper.insert(user);
        return true;
    }


    public List<Users> select() {
        return userMapper.select();
    }


}
