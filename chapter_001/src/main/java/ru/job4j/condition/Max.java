package ru.job4j.condition;

public class Max {
    public int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }
    public int max(int left, int second, int third) {
        int result = max(left, max(second, third));
        return result;
    }
    public int max(int left, int second, int third, int fourth) {
        int result = max(left, max(second, max(third, fourth)));
        return result;
    }
}