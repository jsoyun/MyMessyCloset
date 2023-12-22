package com.favorite.project.dao;


import com.favorite.project.entity.UserCloset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class ClosetDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    private final DataSource databaseConnector;

    //Autowired로 databaseConnector 객체를 빈으로 등록한다
    @Autowired
    public ClosetDao(DataSource databaseConnector) {
        System.out.println("cloasetDAO Autowired");
        this.databaseConnector = databaseConnector;

    }

    //데이터베이스 작업을 수행하는 메서드 작성


    //옷장 채우기
    public void addCloset(UserCloset userCloset) throws SQLException {


        //데이터베이스 연결
        connection = databaseConnector.getConnection();
        //sql 쿼리 작성
        String sql = "INSERT INTO userCloset ( color, notes,clothes_id, user_id)\n" +
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


//        finally {
//            DatabaseConnector.close(connection, preparedStatement);
//        }


    }


    public int getUserClosetCount() throws SQLException {

        connection = databaseConnector.getConnection();
        preparedStatement = connection.prepareStatement("select count(*) from userCloset");
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        return count;


//        PreparedStatement ps = c.prepareStatement("select count(*) from users");
//
//        ResultSet rs = ps.executeQuery();
//        rs.next();
//        int count = rs.getInt(1);
//
//        rs.close();
//        ps.close();
//        c.close();
//
//        return count;


    }

    public Integer find(UserCloset userCloset) {
        return userCloset.getId();


    }
}