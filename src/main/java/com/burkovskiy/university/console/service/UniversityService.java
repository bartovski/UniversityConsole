package com.burkovskiy.university.console.service;


import com.burkovskiy.university.console.dao.UniversityDAO;

public class UniversityService {

    CommandFactory commandFactory;

    public UniversityService(UniversityDAO dao) {
        this.commandFactory = new CommandFactory(dao);
    }

    public void answerTheRequest(String line) {
        if (line == null || line.trim().isEmpty()) {
            System.out.println("Command line is empty.");
            return;
        }
        defineAndExecuteCommand(line);
    }

    private void defineAndExecuteCommand(String line) {
        commandFactory.getCommandService(line).execute(line);
    }
}
