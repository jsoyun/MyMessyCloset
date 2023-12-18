package com.favorite.project.dao;

import com.favorite.project.entity.userCloset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class ClosetDao {

//    Connection connection = null;

    private final DataSource databaseConnector;

    //Autowired로 databaseConnector 객체를 빈으로 등록한다
    @Autowired
    public ClosetDao(DataSource databaseConnector){
        System.out.println("cloasetDAO Autowired");
        this.databaseConnector = databaseConnector;

    }

    //데이터베이스 작업을 수행하는 메서드 작성



   //옷장 채우기
    public void addCloset(userCloset userCloset){
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        //데이터베이스 연결
        try{
            connection = databaseConnector.getConnection();
            //sql 쿼리 작성
            String sql= "INSERT INTO userCloset ( color, notes,clothes_id, user_id)\n" +
                    "VALUES \n" +
                    "    (?, ?, ?, ?);\n";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userCloset.getColor());
            preparedStatement.setString(2, userCloset.getNotes());
            // 만약 값이 없으면 setNull로 처리
            if (userCloset.getClothes_id() != 0) {
                preparedStatement.setInt(3, userCloset.getClothes_id());
            } else {
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            }

            preparedStatement.setInt(4, userCloset.getUser_id());



            preparedStatement.executeUpdate();




        } catch (Exception e){
            e.printStackTrace();


        }

//        finally {
//            DatabaseConnector.close(connection, preparedStatement);
//        }




    }


    public Integer find(userCloset userCloset){
        return  userCloset.getId();


    }
}
