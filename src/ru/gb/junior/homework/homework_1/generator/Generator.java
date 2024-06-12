package ru.gb.junior.homework.homework_1.generator;

import ru.gb.junior.homework.homework_1.Department;
import ru.gb.junior.homework.homework_1.Person;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private int youngestPerson = 23;
    private int oldestPerson = 65;
    private int lowestSalary = 50000;
    private int highestSalary = 200000;
    private final String[] lastNameMaleBase = new String[]{
            "Иванов", "Петров", "Тарасов", "Владимиров", "Сидоров", "Дмитриев", "Степанов", "Никитин", "Андреев", "Егоров"
    };
    private final String[] lastNameFemaleBase = new String[]{
            "Иванова", "Петрова", "Тарасова", "Владимирова", "Сидорова", "Дмитриева", "Степанова", "Никитина", "Андреева", "Егорова"
    };
    private final String[] firstNameMaleBase = new String[]{
            "Иван", "Петр", "Тарас", "Владимир", "Сидор", "Дмитрий", "Степан", "Никита", "Андрей", "Егор"
    };
    private final String[] firstNameFemaleBase = new String[]{
            "Инна", "Полина", "Татьяна", "Виктория", "Светлана", "Дарья", "София", "Наталья", "Алла", "Екатерина"
    };

    private final String[] departmentsBase = new String[]{
            "Отдел продаж", "Отдел маркетинга", "Юридический отдел" //, "Бухгалтерия", "Отдел качества"
    };

    public int getRandomInt(int bound){
        return ThreadLocalRandom.current().nextInt(bound);
    }

    public String generateMaleLastName(){
        return lastNameMaleBase[getRandomInt(lastNameMaleBase.length)];
    }

    public String generateMaleFirstName(){
        return firstNameMaleBase[getRandomInt(firstNameMaleBase.length)];
    }

    public String generateFemaleLastName(){
        return lastNameFemaleBase[getRandomInt(lastNameMaleBase.length)];
    }

    public String generateFemaleFirstName(){
        return firstNameFemaleBase[getRandomInt(firstNameFemaleBase.length)];
    }

    public Department generateDepartment(){
        return new Department(departmentsBase[getRandomInt(departmentsBase.length)]);
    }

    public Gender generateGender(){
        return Gender.randGender();
    }

    public int generateAge(){
        return ThreadLocalRandom.current().nextInt(youngestPerson, oldestPerson);
    }

    public double generateSalary(){
        return ThreadLocalRandom.current().nextInt(lowestSalary, highestSalary);
    }

    public Person generatePerson() {
        Gender gender = generateGender();
        if (gender == Gender.Male) {
            return new Person(generateMaleLastName(), generateMaleFirstName(), generateAge(), generateSalary(), generateDepartment(), gender);
        } else {
            return new Person(generateFemaleLastName(), generateFemaleFirstName(), generateAge(), generateSalary(), generateDepartment(), gender);
        }
    }
}
