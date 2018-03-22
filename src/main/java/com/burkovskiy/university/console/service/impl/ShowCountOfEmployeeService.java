package com.burkovskiy.university.console.service.impl;

import com.burkovskiy.university.console.dao.UniversityDAO;
import com.burkovskiy.university.console.service.AbstractCommandService;
import com.burkovskiy.university.console.util.Constants;
import com.burkovskiy.university.console.util.StringUtils;

public class ShowCountOfEmployeeService extends AbstractCommandService{

    public ShowCountOfEmployeeService(UniversityDAO dao) {
        super(dao);
    }

    @Override
    public void execute(String command) {
        String departmentName = command.substring(command.toLowerCase().indexOf(Constants.SHOW_COUNT_OF_EMPLOYEE_FOR) + Constants.SHOW_COUNT_OF_EMPLOYEE_FOR.length()).trim();
        departmentName = StringUtils.removeDot(departmentName);

        if (departmentName.trim().isEmpty()) {
            System.out.println("Department name is empty.");
            return;
        }
        int count = getDao().getCountOfEmployeeForDepartment(departmentName.toLowerCase());
        if (count == 0) {
            if (getDao().checkIfDepartmentExist(departmentName.toLowerCase())) {
                System.out.println(0);
            } else {
                System.out.println("Department " + departmentName + " not found.");
            }
        } else {
            System.out.println(count);
        }
    }
}
