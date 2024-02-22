package com.favorite.project.Board.Mapper;

import com.favorite.project.Board.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO Board (createdAt,boardType, clothesId, price, rentalHours, content, imageUrl, location,status) VALUES (#{board.createdAt},#{board.boardType}, #{board.clothesId}, #{board.price} , #{board.rentalHours},#{board.content}, #{board.imageUrl}, #{board.location}, #{board.status} )")
    boolean insertBoard(@Param("board") Board board);
}
