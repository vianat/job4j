package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result;
        if (first > second & first > third) {
            result = first;
        } else if (second > first & second > third) {
            result = second;
        } else {
            result = third;
        }
        return result;
    }
}
