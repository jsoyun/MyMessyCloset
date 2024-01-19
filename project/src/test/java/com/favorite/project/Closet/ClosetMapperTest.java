package com.favorite.project.Closet;

import com.favorite.project.Closet.Mapper.ClosetMapper;
import com.favorite.project.Closet.domain.UserCloset;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

//@RequiredArgsConstructorㄴ
public class ClosetMapperTest {
    @Mock
    private ClosetMapper closetMapper;

    @BeforeEach
    public void set() {
        MockitoAnnotations.openMocks(this);

    }


    @Test
    public void insertClosetMapper() {
        //given
        UserCloset closet = UserCloset.builder().id(1).color("분홍색").notes("이것은 내가 만든 옷장이니라").build();
        when(closetMapper.insertUserCloset(closet)).thenReturn(true);
        //when
        closetMapper.insertUserCloset(closet);
        //then
        Assertions.assertThat(closet.getColor().equals("분홍색"));


    }


}
