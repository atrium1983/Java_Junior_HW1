package ru.gb.junior.homework.homework_1;

public class Department implements Comparable<Department>{
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Department o) {
        return this.getName().length() - o.getName().length();
    }
}
