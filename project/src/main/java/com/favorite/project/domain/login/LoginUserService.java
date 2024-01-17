package com.favorite.project.domain.login;

import com.favorite.project.domain.entity.User;
import com.favorite.project.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginUserService {
    private final UserMapper userMapper;

    public Optional<User> getUserByEmail(User user) {

        return Optional.ofNullable(userMapper.getByEmail(user.getEmail()));
    }
}
