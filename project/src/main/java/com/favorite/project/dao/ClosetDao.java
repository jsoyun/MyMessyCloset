package com.favorite.project.dao;

import com.favorite.project.util.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.favorite.project.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ClosetDao {

//    Connection connection = null;

    private final DatabaseConnector databaseConnector;

    //Autowired로 databaseConnector 객체를 빈으로 등록한다
    @Autowired
    public ClosetDao(DatabaseConnector databaseConnector){
        System.out.println("cloasetDAO Autowired");
        this.databaseConnector = databaseConnector;

    }



    //실제 데이터베이스 작업을 수행하는 메서드 작성











}
