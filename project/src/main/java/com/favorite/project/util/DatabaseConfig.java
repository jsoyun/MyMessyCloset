package com.favorite.project.util;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration

public class DatabaseConfig {


    //DatabaseConnector 객체를 빈으로 등록할 수 있게 설정해둠

    @Bean
    public DatabaseConnector databaseConnector(){
        System.out.println("DatabaseConfig내의 Bean");
        return new DatabaseConnector();

    }



}
