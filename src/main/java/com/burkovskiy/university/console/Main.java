package com.burkovskiy.university.console;

import com.burkovskiy.university.console.service.UniversityService;
import com.burkovskiy.university.console.dao.UniversityDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        UniversityDAO dao = new UniversityDAO();
        UniversityService service = new UniversityService(dao);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a command: ");
        String line = null;
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if ("exit".equalsIgnoreCase(line)) break;

            service.answerTheRequest(line);
        }
        System.exit(0);
    }
}
