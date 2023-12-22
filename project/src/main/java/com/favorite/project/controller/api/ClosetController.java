package com.favorite.project.controller.api;


import com.favorite.project.entity.UserCloset;
import com.favorite.project.exceptions.SQLExceptionHandler;
import com.favorite.project.service.ClosetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/AddCloset")
public class ClosetController {

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
