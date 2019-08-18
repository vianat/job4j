package ru.job4j.array;

import java.util.Arrays;

public class Turn {
    public int[] back(int[] array) {
//        System.out.println(Arrays.toString(array));
        for (int i = 0, last = array.length-1; i < array.length/2; i++, last--) {
//            System.out.println("first "+array[i]);
//            System.out.println("last ["+ last +"] "+ array[last]);
//            System.out.println("--");
            int temp = array[i];
            array[i] = array[last];
            array[last] = temp;
        }
//        System.out.println(Arrays.toString(array));
        return array;
    }
}
