package com.favorite.project.User.RestController;

//import com.favorite.project.mapper.UserMapper;

import com.favorite.project.User.UserDataService;
import com.favorite.project.User.UserService;
import com.favorite.project.User.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final UserService userService;


    @PostMapping("/signup")
    public boolean signup(@RequestBody UserDTO userDTO) {
        return userService.insertOneUser(userDTO);

    }


}
