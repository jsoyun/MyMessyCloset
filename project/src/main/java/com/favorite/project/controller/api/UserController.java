package com.favorite.project.controller.api;

//import com.favorite.project.mapper.UserMapper;

import com.favorite.project.dto.UserDTO;
import com.favorite.project.entity.Users;
import com.favorite.project.service.UserService;
//import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();

    }


    @PostMapping
    public boolean insertUserData(@RequestBody UserDTO userDTO) {
        return userService.insertOneUser(userDTO);

    }

    @GetMapping(value = "/testSelect")
    public List<Users> test() {
        return userService.select();
    }

}
