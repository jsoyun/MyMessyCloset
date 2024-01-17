package com.favorite.project.Closet;

import com.favorite.project.Closet.dao.ClosetDao;

import com.favorite.project.Closet.domain.UserCloset;
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
