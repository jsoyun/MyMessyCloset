package com.favorite.project.User.RestController;

import com.favorite.project.User.LoginService;
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

    //TODO: 예외 일괄처리 @ExceptionHandler 사용 (bindingResulte도 처리)
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


        try {

            LoginResponseDTO loginResponseDTO = loginService.checkLoginForm(loginRequestDTO);
            return ResponseEntity.ok(loginResponseDTO);
        } catch (Exception exception) {
            // User not found
            log.error("exception = {}", exception);
            return ResponseEntity.badRequest().build();
        }

//TODO: 일치하는 회원정보가 없을 때 메인화면으로 리다이렉트


    }
}
