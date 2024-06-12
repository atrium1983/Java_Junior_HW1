package ru.gb.junior.homework.homework_1;

import ru.gb.junior.homework.homework_1.generator.Gender;

public class Person implements PersonsListItem<Person>{
    private String lastName;
    private String firstName;
    private int age;
    private double salary;
    private Department depart;
    private Gender gender;

    public Person(String lastName, String firstName, int age, double salary, Department depart, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.salary = salary;
        this.depart = depart;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepart() {
        return depart;
    }

    public void setDepart(Department depart) {
        this.depart = depart;
    }

    public String getInfo(){
        return this.toString();
    }

    @Override
    public String toString() {
        return "Фамилия = " + getLastName() +
                ", Имя = " + getFirstName() +
                "| Возраст = " + getAge() +
                "| Зарплата = " + getSalary() +
                "| Отдел = " + getDepart() +
                "| Пол = " + getGender();
    }
}
