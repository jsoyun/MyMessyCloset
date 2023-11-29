package com.favorite.project;

import com.favorite.project.model.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyRestController {
    private UserData userData;

//    @GetMapping("/restAPI")
//    public Map<String, Object> restAPI(@RequestParam("name") String name, @RequestParam("age") int age){
//        System.out.println("userData"+userData.getName());
//        Map<String, Object> getUser  = new HashMap<>();
//        getUser.put("name",userData.getName());
//        getUser.put("age",userData.getAge());
//        return getUser;
//
//    }


    @PostMapping("/signData")
    public ResponseEntity<Map<String, Object>> signData(@RequestBody UserData userData){
        Map<String, Object> saveData  = new HashMap<>();
        this.userData = userData;

        saveData.put("name",userData.getName());
        saveData.put("age",userData.getAge());
        return new ResponseEntity<>(saveData, HttpStatus.OK);
    }

    @GetMapping("/showUserData")
    public ResponseEntity<UserData> showData(){
        return  new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @GetMapping("/checkUserData")
    public ResponseEntity<Boolean> checkUserData(@RequestParam("name") String name, @RequestParam("age") int age ){
        //파람으로 넘겨준 값과 기존에 저장된 userData가 일치한지 확인.
        System.out.println("name" + name);
        System.out.println("age = " + age);

        if (Objects.equals(name, userData.getName()) && age == userData.getAge()){
            System.out.println("true = " + true);
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            System.out.println("false = " + false);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }



    }


}
