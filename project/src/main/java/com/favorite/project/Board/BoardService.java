package com.favorite.project.Board;

import com.favorite.project.Board.Mapper.BoardMapper;
import com.favorite.project.Board.domain.Board;
import com.favorite.project.Board.dto.BoardAddDto;
import com.favorite.project.Board.dto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    //TODO: 판매 또는 대여 게시판 올리기

    public BoardResponseDto PostBoard(BoardAddDto boardAddDto) {
        Board board = boardAddDto.toBoard(boardAddDto);
        Board createdBoard = boardMapper.insertBoard(board);
        return BoardResponseDto.builder().build().toBoardResponse(createdBoard);


    }


}
