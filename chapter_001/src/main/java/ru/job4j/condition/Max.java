package ru.job4j.condition;

public class Max {
    public int max(int left, int right) {
        int result = left == right ? right : (left > right ? left : right);
        return result;
    }
}
