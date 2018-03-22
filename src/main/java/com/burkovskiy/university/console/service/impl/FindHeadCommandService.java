package com.burkovskiy.university.console.service.impl;

import com.burkovskiy.university.console.dao.UniversityDAO;
import com.burkovskiy.university.console.service.AbstractCommandService;
import com.burkovskiy.university.console.util.Constants;
import com.burkovskiy.university.console.util.StringUtils;

public class FindHeadCommandService extends AbstractCommandService {

    public FindHeadCommandService(UniversityDAO dao) {
        super(dao);
    }

    @Override
    public void execute(String command) {
        String departmentName = command.substring(command.toLowerCase().indexOf(Constants.WHO_IS_HEAD_OF_DEPARTMENT) + Constants.WHO_IS_HEAD_OF_DEPARTMENT.length()).trim();
        departmentName = StringUtils.removeDot(departmentName);
        if (departmentName.trim().isEmpty()) {
            System.out.println("Department name is empty.");
            return;
        }
        String headOfDepartmentName = getDao().getHeadOfDepartmentName(departmentName.toLowerCase());
        if (headOfDepartmentName == null) {
            System.out.println("Department " + departmentName + " not found.");
        } else {
            System.out.println("Head of " + departmentName + " department is " + headOfDepartmentName);
        }
    }
}
