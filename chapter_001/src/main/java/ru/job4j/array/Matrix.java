package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        for (int i = 0, t = 1; i < size; i++, t++) {

            for (int x = 0, n = 1; x < size; x++, n++) {

                table[i][x] = t * n;
            }
        }
        return table;
    }
}
