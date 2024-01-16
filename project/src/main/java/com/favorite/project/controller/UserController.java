package com.favorite.project.controller;

//import com.favorite.project.mapper.UserMapper;

import com.favorite.project.domain.ClosetService;
import com.favorite.project.domain.entity.User;
import com.favorite.project.domain.entity.UserCloset;
import com.favorite.project.controller.dto.UserDTO;
import com.favorite.project.domain.UserService;
import com.favorite.project.exceptions.SQLExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //json객체
    @GetMapping
    public List<User> getAllUsers() {

//        return userService.getAllUsers();

//        try {
//            return userService.select();
//        } catch (RuntimeException runtimeException) {
//            logger.error(String.valueOf(runtimeException));
//            return
//
//
//        }

        return userService.select();


    }


    @PostMapping
    public boolean insertUserData(@RequestBody UserDTO userDTO) {
        return userService.insertOneUser(userDTO);

    }

    //뷰로 가져오기
    @GetMapping("/showUser")
    public ModelAndView showUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userList");
        return modelAndView;
    }


//    @GetMapping(value = "/testSelect")
//    public List<Users> test() {
//        return userService.select();
//    }   @GetMapping(value = "/testSelect")
//    public List<Users> test() {
//        return userService.select();
//    }

    @RestController
    @RequestMapping("/api/AddCloset")
    public static class ClosetController {

        private final ClosetService closetService;

        @Autowired
        public ClosetController(ClosetService closetService) {
            this.closetService = closetService;

        }


        @PostMapping

        public ResponseEntity<Object> addCloset(@RequestBody UserCloset userCloset) {

            try {
                closetService.addCloset(userCloset);
                Map<String, String> successResponse = new HashMap<>();
                successResponse.put("message", "옷장이 생성되었습니다.");
                return ResponseEntity.ok(successResponse);

            } catch (SQLException e) {
                String errorMessage = SQLExceptionHandler.handleSQLException(e);
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", errorMessage);
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }


        }
    }
}
