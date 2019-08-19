package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        if (finish == 2) {
            return 1;
        }
        for (int i = 2; i <= finish; i++) {
            for (int x = 2; x <= i; x++) {
                if (i % x == 0 && x < i) {
                    break;
                } else if (i % x == 0 && x == i) {
                    count++;
                }
            }
        }
        return count;
    }
}