package com.burkovskiy.university.console.service;

import com.burkovskiy.university.console.dao.UniversityDAO;

public class UniversityServiceTest {

    public static void main(String[] args) {
        UniversityDAO dao = new UniversityDAO();
        UniversityService service = new UniversityService(dao);

        System.out.println("Who is head of department Engineering");
        service.answerTheRequest("Who is head of department Engineering");

        System.out.println();

        System.out.println("Who is head of department Sociology");
        service.answerTheRequest("Who is head of department Sociology");

        System.out.println();

        System.out.println("Who is head of department dep");
        service.answerTheRequest("Who is head of department dep");

        System.out.println();
        System.out.println();

        System.out.println("Show Engineering statistic");
        service.answerTheRequest("Show Engineering statistic");

        System.out.println();

        System.out.println("Show Engineer statistic");
        service.answerTheRequest("Show Engineer statistic");

        System.out.println();

        System.out.println("Show Sociology statistic");
        service.answerTheRequest("Show Sociology statistic");

        System.out.println();
        System.out.println();

        System.out.println("Show the average salary for department Biochemistry");
        service.answerTheRequest("Show the average salary for department Biochemistry");

        System.out.println();

        System.out.println("Show the average salary for department Sociology");
        service.answerTheRequest("Show the average salary for department Sociology");

        System.out.println();

        System.out.println("Show the average salary for department History");
        service.answerTheRequest("Show the average salary for department History");

        System.out.println();
        System.out.println();

        System.out.println("Show count of employee for Engineering");
        service.answerTheRequest("Show count of employee for Engineering");

        System.out.println("Show count of employee for Sociology");
        service.answerTheRequest("Show count of employee for Sociology");

        System.out.println();
        System.out.println();

        System.out.println("Global search by a");
        service.answerTheRequest("Global search by a");

        System.out.println("Global search by 0");
        service.answerTheRequest("Global search by 0");

        System.out.println("Global search by Steve");
        service.answerTheRequest("Global search by Steve");

        System.out.println("Global search by dhrhrh4t4y4");
        service.answerTheRequest("Global search by dhrhrh4t4y4");
    }
}
