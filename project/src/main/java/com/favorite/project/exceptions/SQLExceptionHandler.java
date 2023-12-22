package com.favorite.project.exceptions;

import java.sql.SQLException;

public class SQLExceptionHandler {
    public static String handleSQLException(SQLException e){
        String errorMessage = e.getMessage();

        if (containsCaseInsensitive(errorMessage, "foreign key constraint fails")){
            System.out.println("에러핸들링foreign");
            return "해당하는 옷이 없습니다.";
        } else if (containsCaseInsensitive(errorMessage,"unique constraint")){
            System.out.println("에러핸들링unique");
            return "중복된 데이터입니다.";
        } else{
            System.out.println("에러핸들링 예외발생");
            return "SQL 예외 발생: " + errorMessage;
        }

    }

    private static boolean containsCaseInsensitive(String source, String target){
        return source.toLowerCase().contains(target.toLowerCase());

    }

}
