package ru.gb.junior.homework.homework_1;

import ru.gb.junior.homework.homework_1.generator.Gender;

public interface PersonsListItem<T> {
    Gender getGender();
    String getLastName();
    String getFirstName();
    int getAge();
    double getSalary();
    Department getDepart();
    String getInfo();
}
