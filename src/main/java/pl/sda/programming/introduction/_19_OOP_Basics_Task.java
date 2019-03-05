package pl.sda.programming.introduction;


import pl.sda.programming.introduction.model.Employee;
import pl.sda.programming.introduction.model.EmployeeUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class _19_OOP_Basics_Task {

    public static void main(String[] args) {
        /*

        1. create package: pl.company.model
        2. add class Employee:
           - add immutable fields:
             * first name
             * family name
             * pesel
             * birthday  java.time.LocalDate date = LocalDate.of(2019, 2, 1);

           - add mutable
             * salary
             * job title

           - add constructor for immutable fields

           - add getters for all fields
           - add setter for job title
           - add mutation for salary - it should increase or decrease by given amount,
             cannot be lower then 1000.

         3. Create class EmployeeUtil with static methods:
           - float getAverageSalary(Employee[] employees)
           - List<Employee> findByJobTitleStartingWith(String title, Employee[] arr)

        4. Use Scanner to get input from user and create objects of Employee class.
         */

        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        boolean finished = false;
        do {
            System.out.println("Please provide employee first name:");
            String firstName = scanner.next();

            System.out.println("Please provide employee last name:");
            String lastName = scanner.next();

            System.out.println("Please provide employee pesel:");
            String pesel = scanner.next();

            System.out.println("Please provide date of birth:");
            System.out.println("Year:");
            int year = scanner.nextInt();
            System.out.println("Month:");
            int month = scanner.nextInt();
            System.out.println("Day:");
            int day = scanner.nextInt();

            LocalDate birthday = LocalDate.of(year, month, day);

            Employee employee = new Employee(firstName, lastName, pesel, birthday);
            employees.add(employee);

            System.out.println("Please provide employee salary:");
            employee.setSalary(scanner.nextFloat());
            scanner.nextLine();

            System.out.println("Please provide job title:");
            employee.setJobTitle(scanner.nextLine());

            System.out.println("Please provide 'yes' if you want to add next employee");
            String response = scanner.next();
            finished = !response.equalsIgnoreCase("yes");
        } while (!finished);

        System.out.println("Created employees: " + employees.size());

        // example how to convert List to array.
        float avgSalary = EmployeeUtil
                .getAverageSalary(employees.toArray(new Employee[0]));
        System.out.println("Average salary is: " + avgSalary);

        System.out.println("Please provide starting title letters:");
        String title = scanner.next();
        List<Employee> result = EmployeeUtil
                .findByJobTitleStartingWith(title, employees.toArray(new Employee[0]));

        for (Employee employee : result) {
            System.out.println(employee.getFullName());
        }
    }
}
