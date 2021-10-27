package ru.anrivlev.lab3;

import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void task1(List<Employee> employees) {
        System.out.println("TASK1");
        Predicate<Employee> isFemale = e -> e.getGender() == Gender.FEMALE;
        Stream stream = employees.stream();
        stream.filter(isFemale).forEach(e -> Accountant.paySalary((Employee) e));
        System.out.println("END OF TASK1\n");
    }
    public static void task2(List<Employee> employees) {
        System.out.println("TASK2");
        Predicate<Employee> isDept19 = e -> e.getDept().equals("19");
        Stream stream = employees.stream();
        stream.filter(isDept19).forEach(e -> Accountant.paySalary((Employee) e));
        System.out.println("END OF TASK2\n");
    }
    public static void task3(List<Employee> employees) {
        System.out.println("TASK3");
        Predicate<Employee> isAgeOver30 = e -> e.getAge() >= 30;
        Predicate<Employee> isDept19 = e -> e.getDept().equals("19");
        Stream stream = employees.stream();
        stream.filter(isDept19).filter(isAgeOver30).forEach(e -> Accountant.paySalary((Employee) e));
        System.out.println("END OF TASK3\n");
    }
    public static void task4(List<Employee> employees) {
        System.out.println("TASK4");
        Predicate<Employee> isRoleManager = e -> e.getRole() == Role.MANAGER;
        Stream stream = employees.stream();
        stream.filter(isRoleManager).forEach(e -> Accountant.paySalary((Employee) e));
        System.out.println("END OF TASK4\n");
    }
    public static void task5(List<Employee> employees) {
        System.out.println("TASK5");
        Predicate<Employee> isRoleStaff = e -> e.getRole() == Role.STAFF;
        Stream stream = employees.stream();
        stream.filter(isRoleStaff).forEach(e -> Accountant.payPremium((Employee) e));
        System.out.println("END OF TASK5\n");
    }
    public static void task6(List<Employee> employees) {
        System.out.println("TASK6");
        Consumer<Employee> paySalary = Accountant::paySalary;
        Stream stream = employees.stream();
        stream.forEach(paySalary);
        System.out.println("END OF TASK6\n");
    }
    public static void task7(List<Employee> employees) {
        System.out.println("TASK7");
        Function<Employee, String> getName = Employee::getGivenName;
        Stream stream = employees.stream();
        stream.map(getName).forEach(System.out::println);
        System.out.println("END OF TASK7\n");
    }
    public static void task8() {
        System.out.println("TASK8");
        Supplier<List<Employee>> ShortList = Employee::CreateShortList;
        List<Employee> employees = ShortList.get();
        Stream stream = employees.stream();
        stream.forEach(e -> System.out.println(e));
        System.out.println("END OF TASK8\n");
    }
    public static void task9(List<Employee> employees) {
        System.out.println("TASK9");
        BiPredicate<Employee, String> checkName= (e, s) -> e.getGivenName().equals(s);
        Stream stream = employees.stream();
        stream.filter(e -> checkName.test((Employee) e, "Emily")).forEach(e -> System.out.println(e));
        System.out.println("END OF TASK9\n");
    }
    public static void main(String[] args) {
        List<Employee> employees = Employee.CreateShortList();

        task1(employees);
        task2(employees);
        task3(employees);
        task4(employees);
        task5(employees);
        task6(employees);
        task7(employees);
        task8();
        task9(employees);
    }
}
