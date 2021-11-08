package ru.anrivlev.lab4;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ru.anrivlev.lab3.*;

public class Main {
    public static void task1a() {
        System.out.println("TASK1.a");
        List<Employee> employees = Employee.CreateShortList();
        employees.stream()
                .map(Employee::getSalary)
                .peek(System.out::println);
        System.out.println("END OF TASK1.a\n");
    }

    public static void task1b() {
        System.out.println("TASK1.b");

        System.out.println("END OF TASK1.b\n");
    }

    public static void task2a() {
        System.out.println("TASK2.a");
        List<Employee> employees = Employee.CreateShortList();
        Predicate<Employee> isFemale = e -> e.getGender() == Gender.FEMALE;
        double femaleSalary = employees.stream()
                .filter(isFemale).map(Employee::getSalary)
                .findFirst()
                .get();
        System.out.println(femaleSalary);
        System.out.println("END OF TASK2.a\n");
    }

    public static void task2b() {
        System.out.println("TASK2.b");

        System.out.println("END OF TASK2.b\n");
    }

    public static void task3a() {
        System.out.println("TASK3.a");
        List<Employee> employees = Employee.CreateShortList();
        Predicate<Employee> isMale = e -> e.getGender() == Gender.MALE;
        Double maxMaleSalary = employees.stream()
                .filter(isMale)
                .map(Employee::getSalary)
                .max(Double::compareTo).get();
        System.out.println("Maximal male salary: " + maxMaleSalary);
        System.out.println("END OF TASK3.a\n");
    }

    public static void task3b() {
        System.out.println("TASK3.b");
        List<Employee> employees = Employee.CreateShortList();
        Predicate<Employee> isMale = e -> e.getGender() == Gender.MALE;
        Double minMaleSalary = employees.stream()
                .filter(isMale)
                .map(Employee::getSalary)
                .min(Double::compareTo).get();
        System.out.println("Minimal male salary: " + minMaleSalary);
        System.out.println("END OF TASK3.b\n");
    }

    public static void task4a() {
        System.out.println("TASK4.a");
        List<Employee> employees = Employee.CreateShortList();
        Predicate<Employee> isFemale = e -> e.getGender() == Gender.FEMALE;
        OptionalDouble averageFemaleAge = employees.stream()
                .filter(isFemale)
                .mapToInt(Employee::getAge)
                .average();
        System.out.println("Average female age: " + averageFemaleAge.getAsDouble());
        System.out.println("END OF TASK4.a\n");
    }

    public static void task4b() {
        System.out.println("TASK4.b");
        List<Employee> employees = Employee.CreateShortList();
        Double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary of all employees: " + totalSalary);
        System.out.println("END OF TASK4.b\n");
    }

    public static void main(String[] args) {
        task1a();
        task1b();
        task2a();
        task2b();
        task3a();
        task3b();
        task4a();
        task4b();
    }
}
