package pl.sda.programming.introduction;


import pl.sda.programming.introduction.model.Employee;

import java.time.LocalDate;

final class _20_Object {

    public static void main(String[] args) {
        // Object is superclass for every class

        // popular object methods:

        Employee employee = new Employee(
                "Jan", "Kowalski", "839202303", LocalDate.of(2000, 1, 1));
        System.out.println("Employee is " + employee.toString());

        // hashcode and equals
        String s1 = "test";
        String s2 = "test";
        boolean areEqual = s1.equals(20); // look inside equals for String

        // instanceof example
        Object x1 = 50;
        Object x2 = "50";
        if (x1 instanceof Integer) {
            System.out.println("x1 is Integer");
            int sum = (Integer) x1 + 100;
        }
        if (x2 instanceof String) {
            System.out.println("x2 is String");
            // int i = (Integer) x2; -- watch out how you cast!!
        }
        if (x1 instanceof String) {
            System.out.println("x1 is String");
        }
        if (x2 instanceof Integer) {
            System.out.println("x2 is Integer");
        }

        // test employee equality
        Employee employee2 = new Employee(
                "Jan", "Kowalski", "839202303", LocalDate.of(2000, 1, 1));
        System.out.println("are equal " + employee.equals(employee2));

        int firstHashcode  = employee.hashCode();
        int secondHashcode = employee2.hashCode();
        System.out.println("First hashcode =  " + firstHashcode);
        System.out.println("Second hashcode = " + secondHashcode);
    }
}
