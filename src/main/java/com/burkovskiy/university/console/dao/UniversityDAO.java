package com.burkovskiy.university.console.dao;

import com.burkovskiy.university.console.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class UniversityDAO extends DatabaseConnection {

    public String getHeadOfDepartmentName(String departmentName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            String query = "SELECT name FROM lector WHERE id = (SELECT head_id FROM department WHERE lower(name) = ?) LIMIT 1";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, departmentName);
            result = ps.executeQuery();
            if (result.next()) {
                return result.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(result, ps, conn);
        }
        return null;
    }

    public int getAverageSalaryForDepartment(String departmentName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            String query = "SELECT avg(salary) FROM lector WHERE id IN (SELECT lector_id FROM department_lector WHERE department_id = (SELECT id FROM department WHERE lower(name) = ? LIMIT 1));";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, departmentName);
            result = ps.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(result, ps, conn);
        }
        return 0;
    }

    public boolean checkIfDepartmentExist(String departmentName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            String query = "SELECT exists (SELECT 1 FROM department WHERE lower(name) = ?)";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, departmentName);
            result = ps.executeQuery();
            if (result.next()) {
                return result.getBoolean(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(result, ps, conn);
        }
        return false;
    }

    public int getCountOfEmployeeForDepartment(String departmentName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            String query = "SELECT count(lector.id) FROM lector WHERE id IN (SELECT lector_id FROM department_lector WHERE department_id = (SELECT id FROM department WHERE lower(name) = ? LIMIT 1));";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, departmentName);
            result = ps.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(result, ps, conn);
        }
        return 0;
    }

    public Map<String, Integer> getDepartmentStatisticByDepartmentName(String departmentName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            String query = "SELECT degree.name, count(degree_id) FROM lector " +
                    "JOIN degree ON degree_id = degree.id WHERE lector.id IN " +
                    "(SELECT lector_id FROM department_lector WHERE department_id = " +
                    "(SELECT id FROM department WHERE lower(name) = ? LIMIT 1)) " +
                    "GROUP BY degree_id, degree.name;";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, departmentName);
            result = ps.executeQuery();
            Map<String, Integer> statistic = new HashMap<>();
            while (result.next()) {
                statistic.put(result.getString("name"), result.getInt("count"));
            }
            return statistic;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(result, ps, conn);
        }
        return null;
    }

    public String searchByTemplate(String template) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            String query = "SELECT name FROM lector WHERE lower(name) LIKE concat('%',?,'%') " +
                    "UNION " +
                    "select cast(salary AS VARCHAR) FROM lector WHERE cast(salary AS VARCHAR) LIKE concat('%',?,'%') " +
                    "UNION " +
                    "SELECT name FROM department WHERE lower(name) LIKE concat('%',?,'%') " +
                    "UNION " +
                    "SELECT name FROM degree WHERE lower(name) LIKE concat('%',?,'%')";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, template);
            ps.setString(2, template);
            ps.setString(3, template);
            ps.setString(4, template);
            result = ps.executeQuery();
            StringBuilder names = new StringBuilder();
            while (result.next()) {
                names.append(result.getString("name")).append(", ");
            }
            return names.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(result, ps, conn);
        }
        return null;
    }
}
