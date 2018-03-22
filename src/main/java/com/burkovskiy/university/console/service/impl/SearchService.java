package com.burkovskiy.university.console.service.impl;

import com.burkovskiy.university.console.dao.UniversityDAO;
import com.burkovskiy.university.console.service.AbstractCommandService;
import com.burkovskiy.university.console.util.Constants;

public class SearchService extends AbstractCommandService {

    public SearchService(UniversityDAO dao) {
        super(dao);
    }

    @Override
    public void execute(String command) {
        String template = command.substring(command.toLowerCase().indexOf(Constants.GLOBAL_SEARCH_BY) + Constants.GLOBAL_SEARCH_BY.length()).trim();
        if (template.trim().isEmpty()) {
            System.out.println("Template is empty.");
            return;
        }
        String names = getDao().searchByTemplate(template.toLowerCase());
        if (names.trim().isEmpty()) {
            System.out.println("Nothing found.");
        } else {
            System.out.println(names.substring(0, names.length() - 2));
        }
    }
}
