package pl.sda.programming.introduction.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeUtil {

    public static float getAverageSalary(Employee[] employees) {
        if (employees.length == 0) {
            return 0;
        }

        float sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.length;
    }

    public static List<Employee> findByJobTitleStartingWith(
            String title, Employee[] employees) {
        if (employees.length == 0) {
            return Collections.emptyList();
            // return new ArrayList<>();
        }

        List<Employee> result = new ArrayList<>();
        String lowerCasedTitle = title.toLowerCase();
        for (Employee employee : employees) {
            if (employee.getJobTitle().toLowerCase().startsWith(lowerCasedTitle)) {
                result.add(employee);
            }
        }
        return result;
    }
}
