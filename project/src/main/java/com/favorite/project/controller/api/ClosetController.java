package com.favorite.project.controller.api;

import com.favorite.project.entity.UserCloset;
import com.favorite.project.service.ClosetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/AddCloset")
public class ClosetController {

    private final ClosetService closetService;

    @Autowired
    public ClosetController(ClosetService closetService){
        this.closetService = closetService;

    }


    @PostMapping
    public ResponseEntity<String> addCloset(@RequestBody UserCloset userCloset){  //RequestBody 이 맵핑이 생성자를 쓰나?

//        Closet closet = new Closet();
//        System.out.println("closet.getPurchase_date() = " + closet.getPurchase_date());
//        System.out.println("타입확인"+ closet.getPurchase_date().getClass().getName() );
        closetService.addCloset(userCloset);
        return ResponseEntity.ok("Item added successfully");

    }
}
