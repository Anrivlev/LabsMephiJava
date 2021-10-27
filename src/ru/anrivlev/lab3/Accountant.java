package ru.anrivlev.lab3;

public class Accountant {
    public static void paySalary(Employee employee) {
        System.out.println("Salary for " + employee.getGivenName() + " " + employee.getSurName() + "!");
    }
    public static void payPremium(Employee employee) {
        int percent;
        switch (employee.getRole()) {
            case STAFF:
                percent = 10;
                break;
            case MANAGER:
                    percent = 20;
                    break;
            case EXECUTIVE:
                percent = 30;
                break;
            default:
                percent = 0;
                break;
        }
        System.out.println("Premium " + percent + "% for " + employee.getGivenName() + " " + employee.getSurName() + "!");
    }
}
