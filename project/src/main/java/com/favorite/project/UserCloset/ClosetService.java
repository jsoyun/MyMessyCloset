package com.favorite.project.UserCloset;

import com.favorite.project.UserCloset.Mapper.ClosetMapper;

import com.favorite.project.UserCloset.domain.UserCloset;
import com.favorite.project.UserCloset.dto.UserClosetAddDto;
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
