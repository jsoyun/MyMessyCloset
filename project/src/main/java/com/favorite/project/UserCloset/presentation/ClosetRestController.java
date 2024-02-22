package com.favorite.project.UserCloset.presentation;

import com.favorite.project.UserCloset.ClosetService;
import com.favorite.project.UserCloset.domain.UserCloset;
import com.favorite.project.UserCloset.dto.UserClosetAddDto;
import com.favorite.project.User.exceptions.SQLExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClosetRestController {

    private final ClosetService closetService;

    @GetMapping("/closets")
    public List<UserCloset> getAllCloset() {

        //TODO: 값이 없을 때 처리

        return closetService.getAllUserClosets();

    }

    //    @PostMapping("/closet")
//    public boolean insertCloset() {
//        closetService.addCloset();
//    }


    @PostMapping("/closet")
    public ResponseEntity<Object> addCloset(@RequestBody UserClosetAddDto closetAddDto) {
        try {
            closetService.insertUserCloset(closetAddDto);
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
