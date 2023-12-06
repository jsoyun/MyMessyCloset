package com.favorite.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;



public class DatabaseConnector {

//    public DatabaseConnector(){
//
//    }

//    Connection conn = null;
//    PreparedStatement pstmt = null;
//    ResultSet rs = null;


//    public DatabaseConnector(){
//
//
//            Connection con = null;
//
//        String server = "localhost";
//        String database = "messyCloset";
//        String user_name = "root";
//        String password = "1517";
//
//
//        try{
//                Class.forName("org.mariadb.jdbc.Driver");
//
//
//            } catch (ClassNotFoundException e){
//                System.err.println("드라이버 로딩 오류:" + e.getMessage());
//                e.printStackTrace();
//
//            }
//
//            try{
//                con = DriverManager.getConnection("jdbc:mariadb://" +
//                        server + "/" +
//                        database +
//                        "?useSSL=false", user_name, password);
//                System.out.println("연결성공~~~~~~~~!~!~!~!~!~!~!");
//
//            } catch (Exception e){
//                System.err.println("드라이버 로딩 오류:" + e.getMessage());
//                e.printStackTrace();
//
//            }
//            System.out.println("conn리턴" + con);
//
//
//
//        try{
//
//            //테스트로 고냥 넣어버림
//            String sql= "INSERT INTO myCloset (category, color, size, brand, season, purchase_date, price, notes)\n" +
//                    "VALUES \n" +
//                    "    ('Shirt', 'Blue', 'Medium', 'YourBrand', 'Spring', '2023-12-05', 29.99, 'Some notes about the item');\n";
//
//            pstmt = con.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
////
////            while (rs.next()){
////                rs.getString("테스트값이다");
//////                ProductVO pVo = new ProductVO();
//////                pVo.setCode(rs.getInt("code"));
//////                pVo.setName(rs.getString("name"));
//////                pVo.setPrice(rs.getInt("price"));
//////                pVo.setPictureUrl(rs.getString("pictureurl"));
//////                pVo.setDescription(rs.getString("description"));
//////
//////                list.add(pVo); //앗 얘를 빼먹었었네!
////            }
//
//
//        } catch(Exception e){
//            System.out.println("값 못가져옴:"+e.getMessage());
//
//
//        } finally {
////            DBManager.close(conn, pstmt, rs);
//        }
//
//
//
//
//
//
//
//    }
//





    public static Connection getConnection(){

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
