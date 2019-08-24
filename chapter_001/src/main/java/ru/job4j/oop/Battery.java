package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }
    public int exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
        return another.load;
    }

}
