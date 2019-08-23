package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        for (int i = 0, last = array.length - 1; i < array.length / 2; i++, last--) {
            int temp = array[i];
            array[i] = array[last];
            array[last] = temp;
        }
        return array;
    }
}
