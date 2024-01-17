package com.favorite.project.User;

import com.favorite.project.User.domain.User;
import com.favorite.project.User.mapper.UserMapper;
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
