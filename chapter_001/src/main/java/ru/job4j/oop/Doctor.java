package ru.job4j.oop;

public class Doctor extends Profession {

    private String direction;
    private String graduatedDate;
    private int age;
    private int expirience;

    public String getDirection() {
        return this.direction;
    }
    public String getGradDate() {
        return this.graduatedDate;
    }
    public int getAge() {
        return this.age;
    }
    public int getExpirience() {
        return this.expirience;
    }
}