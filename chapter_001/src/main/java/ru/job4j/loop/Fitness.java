package ru.job4j.loop;

public class Fitness {
    public int calc(int ivan, int nik) {
        int month = 0;
        while (true) {
            if (ivan > nik) {
                break;
            }
            ivan *= 3;
            nik *= 2;
            month++;
        }
        return month;
    }
}
