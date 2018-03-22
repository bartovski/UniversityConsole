package com.burkovskiy.university.console.service;

import com.burkovskiy.university.console.dao.UniversityDAO;
import com.burkovskiy.university.console.service.impl.*;
import com.burkovskiy.university.console.util.Constants;

public class CommandFactory {

    private AbstractCommandService findHeadOfDepartmentService;
    private AbstractCommandService showDepartmentStatisticService;
    private AbstractCommandService showAverageSalaryService;
    private AbstractCommandService showCountOfEmployeeForDepartmentService;
    private AbstractCommandService globalSearchService;
    private AbstractCommandService dummyCommandService;

    public CommandFactory(UniversityDAO dao) {
        findHeadOfDepartmentService = new FindHeadCommandService(dao);
        showDepartmentStatisticService = new ShowDepartmentStatisticService(dao);
        showAverageSalaryService = new ShowAverageSalaryService(dao);
        showCountOfEmployeeForDepartmentService = new ShowCountOfEmployeeService(dao);
        globalSearchService = new SearchService(dao);
        dummyCommandService = new DummyCommandService(dao);
    }

    public AbstractCommandService getCommandService(String command) {
        String lowerLine = command.toLowerCase().trim();

        if (lowerLine.startsWith(Constants.WHO_IS_HEAD_OF_DEPARTMENT)) {
            return findHeadOfDepartmentService;
        } else if (lowerLine.matches(Constants.SHOW_DEPARTMENT_STATISTIC_BEGIN + ".*" + Constants.SHOW_DEPARTMENT_STATISTIC_END + "\\.?")) {
            return showDepartmentStatisticService;
        } else if (lowerLine.startsWith(Constants.SHOW_THE_AVERAGE_SALARY_FOR_DEPARTMENT)) {
            return showAverageSalaryService;
        } else if (lowerLine.startsWith(Constants.SHOW_COUNT_OF_EMPLOYEE_FOR)) {
            return showCountOfEmployeeForDepartmentService;
        } else if (lowerLine.startsWith(Constants.GLOBAL_SEARCH_BY)) {
            return globalSearchService;
        } else {
            return dummyCommandService;
        }
    }
}
