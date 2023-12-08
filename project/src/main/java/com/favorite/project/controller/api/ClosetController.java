package com.favorite.project.controller.api;

import com.favorite.project.dao.ClosetDao;
import com.favorite.project.entity.Closet;
import com.favorite.project.service.ClosetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
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
    public ResponseEntity<String> addCloset(@RequestBody Closet closet){
//        Closet closet = new Closet();
        System.out.println("closet.getPurchase_date() = " + closet.getPurchase_date());
        System.out.println("타입확인"+ closet.getPurchase_date().getClass().getName() );
        closetService.addCloset(closet);
        return ResponseEntity.ok("Item added successfully");
    }
}
