package com.favorite.project.Board.Mapper;

import com.favorite.project.Board.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO Board (created_at,user_id,board_type, clothes_id, price, rental_Hours, content, image_url, location,status) VALUES (#{board.createdAt},#{board.userId}, #{board.boardType}, #{board.clothesId}, #{board.price} , #{board.rentalHours},#{board.content}, #{board.imageUrl}, #{board.location}, #{board.status} )")
    int insertBoard(@Param("board") Board board);
}
