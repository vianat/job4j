package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double total = amount + amount * (percent / 100);
        int payPerYear = monthly * 12;

        if((total - payPerYear) < 0) return 1;

        while(total > 0){
            total = total - payPerYear;
            year++;
            if(total > 0) total = amount * (percent / 100);
        }
        return year;
    }
}
