package com.burkovskiy.university.console.service.impl;

import com.burkovskiy.university.console.dao.UniversityDAO;
import com.burkovskiy.university.console.service.AbstractCommandService;

public class DummyCommandService extends AbstractCommandService {

    public DummyCommandService(UniversityDAO dao) {
        super(dao);
    }

    @Override
    public void execute(String command) {
        System.out.println("Command not found.");

    }
}
