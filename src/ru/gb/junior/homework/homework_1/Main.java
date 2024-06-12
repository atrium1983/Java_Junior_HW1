package ru.gb.junior.homework.homework_1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PersonsList list = new PersonsList();
        list.generateStaff(5);
        List<Person> persons = list.getPersonsList();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Самый молодой сотрудник : " + findMostYoungestPerson(persons).get());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("В этом департаменте работает сотрудник с самой большой зарплатой : " + findMostExpensiveDepartment(persons).get());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Сотрудники по департаментам : \n" + groupByDepartment(persons));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Сотрудники по названиям департаментов : \n" + groupByDepartmentName(persons));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Самые старшие сотрудники каждого департамента :\n" + getDepartmentOldestPerson(persons));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Сотрудники с минимальными зарплатами в своем отделе :\n" + cheapPersonsInDepartment(persons));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * Найти самого молодого сотрудника
     */
    static Optional<Person> findMostYoungestPerson(List<Person> people) {
        return people.stream()
                .min(Comparator.comparingInt(Person::getAge));
    }

    /**
     * Найти департамент, в котором работает сотрудник с самой большой зарплатой
     */
    static Optional<Department> findMostExpensiveDepartment(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingDouble(Person::getSalary))
                .map(Person::getDepart);
    }

    /**
     * Сгруппировать сотрудников по департаментам
     */
    static Map<Department, List<Person>> groupByDepartment(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getDepart));
    }

    /**
     * Сгруппировать сотрудников по названиям департаментов
     */
    static Map<String, List<Person>> groupByDepartmentName(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getDepart().getName()));
    }

    /**
     * В каждом департаменте найти самого старшего сотрудника
     */
    static Map<String, Person> getDepartmentOldestPerson(List<Person> people) {
        return people.stream().collect(Collectors.toMap(
                person -> person.getDepart().getName(),
                Function.identity(),
                (a,b) -> {
                    if(a.getAge() > b.getAge()){
                        return a;
                    }
                    return b;
                }));
    }

    /**
     * *Найти сотрудников с минимальными зарплатами в своем отделе
     * (прим. можно реализовать в два запроса)
     */
    static List<Person> cheapPersonsInDepartment(List<Person> people) {
         return people.stream().collect(Collectors.toMap(
                person -> person.getDepart().getName(),
                Function.identity(),
                (a,b) -> {
                    if(a.getSalary() < b.getSalary()){
                        return a;
                    }
                    return b;
                })).values().stream().toList();
    }
}
