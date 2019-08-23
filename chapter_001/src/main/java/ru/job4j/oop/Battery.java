package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }
    public void exchange(Battery another) {
        int value = another.load;
        this.load -= value;
        another.load += value;
    }

    public static void main(String[] args) {
        Battery battHight = new Battery(55);
        Battery battLow = new Battery(10);
//        System.out.println("battHight before " + battHight.load);
//        System.out.println("battLow before " + battLow.load);
        battHight.exchange(battLow);
//        System.out.println("battHight after " + battHight.load);
//        System.out.println("battLow after " + battLow.load);
    }
}
