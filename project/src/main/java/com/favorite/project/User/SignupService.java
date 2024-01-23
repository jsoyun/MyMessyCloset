package com.favorite.project.User;

import com.favorite.project.User.domain.User;
import com.favorite.project.User.dto.UserDTO;
import com.favorite.project.User.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final UserMapper userMapper;


    public boolean signup(UserDTO userDTO) {


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

}
