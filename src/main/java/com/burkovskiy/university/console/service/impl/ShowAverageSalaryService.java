package com.burkovskiy.university.console.service.impl;

import com.burkovskiy.university.console.dao.UniversityDAO;
import com.burkovskiy.university.console.service.AbstractCommandService;
import com.burkovskiy.university.console.util.Constants;
import com.burkovskiy.university.console.util.StringUtils;

public class ShowAverageSalaryService extends AbstractCommandService {

    public ShowAverageSalaryService(UniversityDAO dao) {
        super(dao);
    }

    @Override
    public void execute(String command) {
        String departmentName = command.substring(command.toLowerCase().indexOf(Constants.SHOW_THE_AVERAGE_SALARY_FOR_DEPARTMENT) + Constants.SHOW_THE_AVERAGE_SALARY_FOR_DEPARTMENT.length()).trim();
        departmentName = StringUtils.removeDot(departmentName);

        if (departmentName.trim().isEmpty()) {
            System.out.println("Department name is empty.");
            return;
        }

        int avgSalaryOfDepartment = getDao().getAverageSalaryForDepartment(departmentName.toLowerCase());
        if (avgSalaryOfDepartment == 0) {
            if (getDao().checkIfDepartmentExist(departmentName.toLowerCase())) {
                if (getDao().getCountOfEmployeeForDepartment(departmentName.toLowerCase()) == 0) {
                    System.out.println("There are no lectors in the department " + departmentName);
                } else {
                    System.out.println("No information about salary in department " + departmentName);
                }
            } else {
                System.out.println("Department " + departmentName + " not found.");
            }
        } else {
            System.out.println("The average salary of " + departmentName + " is " + avgSalaryOfDepartment);
        }
    }
}
