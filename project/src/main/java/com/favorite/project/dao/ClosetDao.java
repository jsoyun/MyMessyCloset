package com.favorite.project.dao;

import com.favorite.project.entity.myCloset;
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
    public void addCloset(myCloset myCloset){
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        //데이터베이스 연결
        try{
            connection = databaseConnector.getConnection();
            //sql 쿼리 작성
            String sql= "INSERT INTO myCloset ( color, notes,clothes_id, user_id)\n" +
                    "VALUES \n" +
                    "    (?, ?, ?, ?);\n";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, myCloset.getColor());
            preparedStatement.setString(2, myCloset.getNotes());
            // 만약 값이 없으면 setNull로 처리
            if (myCloset.getClothes_id() != 0) {
                preparedStatement.setInt(3, myCloset.getClothes_id());
            } else {
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            }

            if (myCloset.getUser_id() != 0) {
                preparedStatement.setInt(4, myCloset.getUser_id());
            } else {
                preparedStatement.setNull(4, java.sql.Types.INTEGER);
            }



            preparedStatement.executeUpdate();




        } catch (Exception e){
            e.printStackTrace();


        }

//        finally {
//            DatabaseConnector.close(connection, preparedStatement);
//        }




    }


    public Integer find(myCloset myCloset){
        return  myCloset.getId();


    }
}
