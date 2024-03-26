package com.favorite.project.Board;

import com.favorite.project.Board.Mapper.BoardMapper;
import com.favorite.project.Board.domain.Board;
import com.favorite.project.Board.dto.BoardAddDto;
import com.favorite.project.Board.dto.BoardResponseDto;
import com.favorite.project.Clothes.Mapper.ClothesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
    private final ClothesMapper clothesMapper;


    //하나의 옷만 올릴 수 있음.
    public BoardResponseDto PostBoard(BoardAddDto boardAddDto) {
        boolean clothes = clothesMapper.checkClothesById(boardAddDto.getClothesId());
        if (!clothes) {
            throw new NoSuchElementException("존재하는 옷이 아닙니다.");


        }
        Board board = boardAddDto.toBoard(boardAddDto);
        boardMapper.insertBoard(board);

        return BoardResponseDto.builder().build().toBoardResponse(board);


    }


}
