package com.favorite.project.UserCloset;

import com.favorite.project.UserCloset.Mapper.ClosetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserClosetValidator {

    private final ClosetMapper closetMapper;

    //유효한 옷장인가
    public boolean checkUserCloset(int userClosetId) {
        return closetMapper.checkUserClosetById(userClosetId);
    }

    //로그인한 유저가 이 옷장의 주인이 맞는가
    public boolean checkUserBySession(Long userId) {
        return closetMapper.checkUserById(userId);
    }


}
