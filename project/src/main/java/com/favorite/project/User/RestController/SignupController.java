package com.favorite.project.User.RestController;

//import com.favorite.project.mapper.UserMapper;

import com.favorite.project.User.SignupService;
import com.favorite.project.User.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class SignupController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final SignupService signupService;


    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO userDTO) {
        UserDTO signup = signupService.signup(userDTO);
        return new ResponseEntity<>(signup, HttpStatus.OK);

    }


}
