package com.favorite.project.Board;

import com.favorite.project.Board.Mapper.BoardMapper;
import com.favorite.project.Board.domain.Board;
import com.favorite.project.Board.domain.BoardStatus;
import com.favorite.project.Board.domain.BoardType;
import com.favorite.project.Board.dto.BoardAddDto;
import com.favorite.project.Board.dto.BoardResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardMapper boardMapper;
    @InjectMocks
    private BoardService boardService;

    @Test
    @DisplayName("게시판 올리기 성공")
    public void PostBoardSuccess() {
//
        BoardAddDto boardAddDto = BoardAddDto.builder()
                .createdAt(LocalDateTime.now())
                .boardType(BoardType.RENT)
                .clothesId(123)
                .price(50.0)
                .rentalHours(4)
                .content("This is a sample content.")
                .imageUrl("https://example.com/image.jpg")
                .location("Sample Location")
                .status(BoardStatus.AVAILABLE)
                .build();

        Board board = boardAddDto.toBoard(boardAddDto);
        //given
        given(boardMapper.insertBoard(any(Board.class))).willReturn(board);
        //when
        BoardResponseDto boardResponseDto = boardService.PostBoard(boardAddDto);
        //then
        Assertions.assertThat(boardMapper.insertBoard(board)).isEqualTo(board);
        Assertions.assertThat(boardResponseDto.getLocation()).isEqualTo(boardAddDto.getLocation());

    }

}
