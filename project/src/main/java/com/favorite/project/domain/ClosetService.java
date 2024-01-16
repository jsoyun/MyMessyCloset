package com.favorite.project.domain;

import com.favorite.project.config.dao.ClosetDao;

import com.favorite.project.domain.entity.UserCloset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
