package com.automation.class01;

class Student {
    int age;
    String name;
}

public class ClassObjectExample {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.name = "Jyothi";
        s2.name = "Dinesh";
        System.out.println(s1.name);
    }
}
