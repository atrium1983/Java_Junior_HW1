package ru.gb.junior.homework.homework_1;

import ru.gb.junior.homework.homework_1.generator.Generator;

import java.util.ArrayList;
import java.util.List;

public class PersonsList<E extends PersonsListItem> {
    private List<E> personsList;
    private Generator generator;

    public PersonsList() {
        personsList = new ArrayList<>();
        generator = new Generator();
    }

    public void addPerson(E person){
        personsList.add(person);
    }

    public void getInfo(){
        System.out.println("Сотрудники нашей конторы. Всего => " + personsList.size());
        for (E person : personsList) {
            System.out.println(person.getInfo());
        }
    }

    public void generateStaff(int number){
        for (int i = 0; i < number; i++) {
            addPerson((E) generator.generatePerson());
        }
        getInfo();
    }

    public List<E> getPersonsList(){
        return personsList;
    }
}
