package com.favorite.project.User;

import com.favorite.project.User.dto.UserDTO;
import com.favorite.project.User.domain.User;
import com.favorite.project.User.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //응집도 : 관련된 게 잘 모여있어야한다.
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final UserMapper userMapper;


    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

//    public Users getById(Long userId) {
////        return userMapper.getById(userId);
//
//    }


    public Optional<User> getUserByEmail(User user) {

        return Optional.ofNullable(userMapper.getByEmail(user.getEmail()));
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public boolean insertOneUser(UserDTO userDTO) {

        try {

            User user = User.builder()
                    .name(userDTO.getName())
                    .email(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .build();

            userMapper.insert(user);

            return true;


        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return false;
        }


    }


    public List<User> select() {
        try {

            return userMapper.select();

        } catch (Exception exception) {
            logger.error("List<user> select(): {}", exception.getMessage());
            throw new RuntimeException(exception);

        }


    }


}
