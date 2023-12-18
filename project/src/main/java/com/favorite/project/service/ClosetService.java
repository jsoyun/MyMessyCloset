package com.favorite.project.service;

import com.favorite.project.dao.ClosetDao;
import com.favorite.project.entity.UserCloset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosetService {
//    private UserRepository userRepository;

    private final ClosetDao closetDao;

    @Autowired
    public ClosetService(ClosetDao closetDao){
        this.closetDao = closetDao;
    }


    public void addCloset(UserCloset userCloset){

        closetDao.addCloset(userCloset);
    }

}
