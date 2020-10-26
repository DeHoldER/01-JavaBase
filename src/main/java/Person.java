package ru.geekbrains;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person() {
    }

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printAllInfo() {
        System.out.println("ФИО: " + name + "\nВозраст: " + age + "\nДолжность: " + position + "\nТелефон: " + phone + "\ne-mail: " + email + "\nЗарплата: " + salary);
    }

    public int getAge() {
        return age;
    }
}
