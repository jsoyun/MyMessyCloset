package com.favorite.project.config;

import java.sql.*;



public class DatabaseConnector {


    public  Connection getConnection(){

        Connection con = null;

        String server = "localhost";
        String database = "messyCloset";
        String user_name = "root";
        String password = "1517";

        try{
            Class.forName("org.mariadb.jdbc.Driver");


        } catch (ClassNotFoundException e){
            System.err.println("드라이버 로딩 오류:" + e.getMessage());
            e.printStackTrace();

        }

        try{
            con = DriverManager.getConnection("jdbc:mariadb://" +
                    server + "/" +
                    database +
                    "?useSSL=false", user_name, password);
            System.out.println("연결성공~~~~~~~~!~!~!~!~!~!~!");

        } catch (Exception e){
            System.err.println("드라이버 로딩 오류:" + e.getMessage());
            e.printStackTrace();

        }
        System.out.println("conn리턴" + con);
        return con;

    }

    //select 수행한 후 리소스 해제를 위한 메소드
    public static void close(Connection con, Statement stmt, ResultSet rs) {
        try{
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //insert, update, delete 작업을 수행한 후 리소스 해제를 위한 메소드
    public static void close(Connection conn, Statement stmt){
        try{
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}
