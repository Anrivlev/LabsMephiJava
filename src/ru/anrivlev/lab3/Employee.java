package ru.anrivlev.lab3;

import java.util.LinkedList;
import java.util.List;

enum Gender {
    MALE,
    FEMALE
}

enum Role {
    STAFF,
    MANAGER,
    EXECUTIVE
}

public class Employee {
    private final String givenName;
    private final String surName;
    private final int age;
    private final Gender gender;
    private final Role role;
    private final String dept;
    private final String eMail;
    private final String phone;
    private final String address;
    private final String city;
    private final String state;
    private final int code;

    public static class Builder {
        private String givenName = null;
        private String surName = null;
        private int age = 0;
        private Gender gender = null;
        private Role role = null;
        private String dept = null;
        private String eMail = null;
        private String phone = null;
        private String address = null;
        private String city = null;
        private String state = null;
        private int code = 0;

        public Builder() {

        }

        public Builder givenName(String val) {
            givenName = val;
            return this;
        }

        public Builder surName(String val) {
            surName = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder gender(Gender val) {
            gender = val;
            return this;
        }

        public Builder role(Role val) {
            role = val;
            return this;
        }

        public Builder dept(String val) {
            dept = val;
            return this;
        }

        public Builder eMail(String val) {
            eMail = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder state(String val) {
            state = val;
            return this;
        }

        public Builder code(int val) {
            code = val;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    private Employee(Builder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        role = builder.role;
        dept = builder.dept;
        eMail = builder.eMail;
        phone = builder.phone;
        address = builder.address;
        city = builder.city;
        state = builder.state;
        code = builder.code;
    }

    public String toString() {
        return "Name: " +
                givenName +
                "; Surname: " +
                surName +
                "; Age: " +
                age +
                "; Gender: " +
                gender +
                "; Role: " +
                role +
                "; Department" +
                dept +
                "; e-mail:" +
                eMail +
                "; phone:" +
                phone +
                "; address:" +
                address +
                "; city:" +
                city +
                "; state:" +
                state +
                "; code:" +
                code;
    }

    public static List<Employee> CreateShortList() {
        List<Employee> result = new LinkedList<>();
        result.add(new Employee.Builder().givenName("John")
                .surName("Smith")
                .age(47)
                .gender(Gender.MALE)
                .role(Role.EXECUTIVE)
                .dept("12")
                .eMail("john.smith@gmail.com")
                .phone("79175817546")
                .address("London, Baker street 47")
                .city("London")
                .state("CA")
                .code(310)
                .build());
        result.add(new Employee.Builder().givenName("Will")
                .surName("Smith")
                .age(42)
                .gender(Gender.MALE)
                .role(Role.MANAGER)
                .dept("12")
                .eMail("will.smith@gmail.com")
                .phone("79175817547")
                .address("London, Baker street 46")
                .city("London")
                .state("CA")
                .code(310)
                .build());
        result.add(new Employee.Builder().givenName("John")
                .surName("Meyers")
                .age(27)
                .gender(Gender.MALE)
                .role(Role.STAFF)
                .dept("11")
                .eMail("john.meyers@gmail.com")
                .phone("79175857546")
                .address("New York, Hammond street 98")
                .city("New York")
                .state("NY")
                .code(718)
                .build());
        result.add(new Employee.Builder().givenName("Elena")
                .surName("Smith")
                .age(48)
                .gender(Gender.FEMALE)
                .role(Role.EXECUTIVE)
                .dept("12")
                .eMail("elena.voronova@gmail.com")
                .phone("79175867549")
                .address("London, Baker street 47")
                .city("London")
                .state("CA")
                .code(310)
                .build());
        result.add(new Employee.Builder().givenName("Anna")
                .surName("Shalame")
                .age(31)
                .gender(Gender.FEMALE)
                .role(Role.STAFF)
                .dept("11")
                .eMail("anna.shalame@gmail.com")
                .phone("79175819876")
                .address("New York, Baker street 18")
                .city("New York")
                .state("NY")
                .code(718)
                .build());
        result.add(new Employee.Builder().givenName("Jack")
                .surName("Wright")
                .age(56)
                .gender(Gender.MALE)
                .role(Role.MANAGER)
                .dept("19")
                .eMail("coolguy67@gmail.com")
                .phone("79175957546")
                .address("Chicago, French avenue 98")
                .city("Chicago")
                .state("IL")
                .code(847)
                .build());
        result.add(new Employee.Builder().givenName("Emily")
                .surName("Wong")
                .age(24)
                .gender(Gender.FEMALE)
                .role(Role.STAFF)
                .dept("19")
                .eMail("emily.wong56@gmail.com")
                .phone("791758657546")
                .address("Chicago, French avenue 47")
                .city("Chicago")
                .state("IL")
                .code(847)
                .build());
        return result;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public String getDept() {
        return dept;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCode() {
        return code;
    }
}
