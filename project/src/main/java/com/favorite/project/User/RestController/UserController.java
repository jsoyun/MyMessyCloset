package com.favorite.project.User.RestController;

import com.favorite.project.User.UserService;
import com.favorite.project.User.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;


    //json객체

    @GetMapping
    public List<User> getAllUsers() {

        return userService.select();


    }


//    //뷰로 가져오기
//
//    @GetMapping("/showUser")
//    public ModelAndView showUser() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("userList");
//        return modelAndView;
//    }


}
