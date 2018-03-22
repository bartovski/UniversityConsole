package com.burkovskiy.university.console.service;

import com.burkovskiy.university.console.dao.UniversityDAO;

public abstract class AbstractCommandService {

    private UniversityDAO dao;

    public AbstractCommandService(UniversityDAO dao) {
        this.dao = dao;
    }

    public UniversityDAO getDao() {
        return dao;
    }

    public void setDao(UniversityDAO dao) {
        this.dao = dao;
    }

    public abstract void execute(String command);
}
