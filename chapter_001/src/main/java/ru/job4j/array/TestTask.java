package ru.job4j.array;

public class TestTask {
    public int[] merge2array(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0, x = 0; x < arr1.length; i += 2, x++) {
            if (arr1[x] < arr2[x]) {
                result[i] = arr1[x];
                result[i + 1] = arr2[x];
            } else {
                result[i] = arr2[x];
                result[i + 1] = arr1[x];
            }
        }
        return result;
    }
}
