package com.favorite.project.User;

import com.favorite.project.User.dto.LoginRequestDTO;
import com.favorite.project.User.domain.User;
import com.favorite.project.User.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    //차근차근 해봅시다.
    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("bindingResult.hasErrors-[GetMapping/login]");
            HashMap<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMap);

        }

        //TODO: 잘못된 아이ㅣ안됨~!


        try {

            LoginResponseDTO loginResponseDTO = loginService.checkLoginForm(loginRequestDTO);


            return ResponseEntity.ok(loginResponseDTO);
        } catch (Exception exception) {

            //java.util.NoSuchElementException: User not found
            log.error("exception ={}", exception);
            return ResponseEntity.badRequest().build();
//            bindingResult.reject("loginFail", "일치하는 회원정보가 없습니다. 다시 시도해주세요");
        }


//        if (loginResponseDTO.isEmpty()) {
//
//            bindingResult.reject("loginFail", "일치하는 회원정보가 없습니다. 다시 시도해주세요");
////            return "redirect:/";
//
//        }


        //TODO: 쿠키만들기

//        //Cookie
//        Cookie idCookie = new Cookie("user_id", String.valueOf(user.get().getUserId()));
//        response.addCookie(idCookie);
//
//


    }
}
