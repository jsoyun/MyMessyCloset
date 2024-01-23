package com.favorite.project.User.RestController;

//import com.favorite.project.mapper.UserMapper;

import com.favorite.project.User.SignupService;
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
public class SignupController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final SignupService signupService;


    @PostMapping("/signup")
    public boolean signup(@RequestBody UserDTO userDTO) {
        return signupService.signup(userDTO);

    }


}
