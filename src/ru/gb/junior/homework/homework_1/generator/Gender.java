package ru.gb.junior.homework.homework_1.generator;

import java.util.Random;

public enum Gender {
    Male, Female;
    private static final Random rand = new Random();
    public static Gender randGender(){
        Gender[] genders = values();
        return genders[rand.nextInt(genders.length)];
    }
}
