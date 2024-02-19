package com.favorite.project;

//import lombok.extern.java.Log;

import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.NumberFormat;

@SpringBootApplication
public class ProjectApplication {


    public static void main(String[] args) {

        SpringApplication.run(ProjectApplication.class, args);

        new CheckMemory();
    }

}
