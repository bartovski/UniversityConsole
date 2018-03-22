package com.burkovskiy.university.console.service.impl;

import com.burkovskiy.university.console.dao.UniversityDAO;
import com.burkovskiy.university.console.service.AbstractCommandService;
import com.burkovskiy.university.console.util.Constants;
import com.burkovskiy.university.console.util.StringUtils;

import java.util.Map;

public class ShowDepartmentStatisticService extends AbstractCommandService{

    public ShowDepartmentStatisticService(UniversityDAO dao) {
        super(dao);
    }

    @Override
    public void execute(String command) {
        String departmentName = command.substring(command.toLowerCase().indexOf(Constants.SHOW_DEPARTMENT_STATISTIC_BEGIN) + Constants.SHOW_DEPARTMENT_STATISTIC_BEGIN.length(), command.indexOf(Constants.SHOW_DEPARTMENT_STATISTIC_END)).trim();
        departmentName = StringUtils.removeDot(departmentName);

        if (departmentName.trim().isEmpty()) {
            System.out.println("Department name is empty.");
            return;
        }

        Map<String, Integer> statistic = getDao().getDepartmentStatisticByDepartmentName(departmentName.toLowerCase());

        if (statistic == null || statistic.isEmpty()) {
            if (getDao().checkIfDepartmentExist(departmentName.toLowerCase())) {
                System.out.println("There are no lectors in the department " + departmentName);
            } else {
                System.out.println("Department " + departmentName + " not found.");
            }
        } else {
            statistic.entrySet().forEach(s -> System.out.println(s.getKey() + " - " + s.getValue()));
        }
    }
}
