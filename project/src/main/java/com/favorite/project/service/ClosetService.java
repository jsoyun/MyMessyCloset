package com.favorite.project.service;

import com.favorite.project.dao.ClosetDao;

import com.favorite.project.entity.UserCloset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ClosetService {

    private final ClosetDao closetDao;

    @Autowired
    public ClosetService(ClosetDao closetDao) {
        this.closetDao = closetDao;
    }

    //    @Transactional
    public void addCloset(UserCloset userCloset) throws SQLException {
        closetDao.addCloset(userCloset);

    }

}
