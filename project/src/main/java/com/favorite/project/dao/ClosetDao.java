//package com.favorite.project.dao;
//
//import com.favorite.project.entity.Closet;
//import com.favorite.project.util.DatabaseConnector;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Repository;
//
//import com.favorite.project.util.DatabaseConnector;
//
//import java.sql.*;
//
//@Repository
//public class ClosetDao {
//
////    Connection connection = null;
//
//    private final DatabaseConnector databaseConnector;
//
//    //Autowired로 databaseConnector 객체를 빈으로 등록한다
//    @Autowired
//    public ClosetDao(DatabaseConnector databaseConnector){
//        System.out.println("cloasetDAO Autowired");
//        this.databaseConnector = databaseConnector;
//
//    }
//
//    //데이터베이스 작업을 수행하는 메서드 작성
//
//
//
//   //옷장 채우기
//    public void addCloset(Closet closet){
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//
//        //데이터베이스 연결
//        try{
//            connection = databaseConnector.getConnection();
//            //sql 쿼리 작성
//            String sql= "INSERT INTO myCloset (category, color, size, brand, season, purchase_date, price, notes)\n" +
//                    "VALUES \n" +
//                    "    (?, ?, ?, ?, ?, ?, ?, ?);\n";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, closet.getCategory());
//            preparedStatement.setString(2, closet.getColor());
//            preparedStatement.setString(3, closet.getSize());
//            preparedStatement.setString(4, closet.getBrand());
//            preparedStatement.setString(5, closet.getSeason());
//            //closet.getPurchase_date() 값이 없어서 java.lang.NullPointerException 나옴
//            //entity키와 클라이언트 키 이름이 달라서 매핑이 안되었음
//            preparedStatement.setDate(6, Date.valueOf(closet.getPurchase_date()));
//            preparedStatement.setInt(7, closet.getPrice());
//            preparedStatement.setString(8, closet.getNotes());
//
//            preparedStatement.executeUpdate();
//
//
//
//
//        } catch (Exception e){
//            e.printStackTrace();
//
//
//        } finally {
//            DatabaseConnector.close(connection, preparedStatement);
//        }
//
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//}
