package com.favorite.project.Closet;

import com.favorite.project.Closet.Mapper.ClosetMapper;

import com.favorite.project.Closet.domain.UserCloset;
import com.favorite.project.Closet.dto.UserClosetAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClosetService {

    private final ClosetMapper closetMapper;


    public List<UserCloset> getAllUserClosets() {
        return closetMapper.getAllUserClosets();
    }

    public boolean insertUserCloset(UserClosetAddDto closetAddDto) throws SQLException {

        UserCloset closet = closetAddDto.toUserClosetEntity();
        closetMapper.insertUserCloset(closet);
        return true;

    }

}
