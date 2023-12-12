package com.favorite.project.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.yml")
public class MariaDBConfiguration {


    @Bean
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public HikariConfig hikariConfig() {

        return new HikariConfig();
    }

    @Bean
    public DataSource HikariDataSource() throws Exception {
        DataSource hikariDataSource = new HikariDataSource(hikariConfig());
        System.out.println("hikariDataSource:"+hikariDataSource.toString());
        return hikariDataSource;
    }


   //hikariDataSource 말고 JDBC드라이버로도 언제든 갈아끼울 수 있게 추가하고 싶음
    //근데 연결이 안됨

//    @Bean
//    public  Connection JDBCConnection(){
//
//        Connection con = null;
//
//        String server = "localhost";
//        String database = "messyCloset";
//        String user_name = "root";
//        String password = "1517";
//
//        try{
//            Class.forName("org.mariadb.jdbc.Driver");
//
//            con =  DriverManager.getConnection("jdbc:mariadb://" +
//                    server + "/" +
//                    database +
//                    "?useSSL=false", user_name, password);
//            System.out.println("연결성공~~~~~~~~!~!~!~!~!~!~!");
//
//
//
//
//        } catch (ClassNotFoundException e){
//            System.err.println("드라이버 로딩 오류:" + e.getMessage());
//            e.printStackTrace();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("conn리턴" + con);
//        return con;
//
//
//    }






}