package ru.job4j.array;
import java.util.Arrays;
/*
 * Class Check проверяет различие элементов в массиве
 * @author Sergei Nikiforov
 * @since 18.08.2019
 * @version 1
 * */
public class Check {
    /*
     * проверяет что в массиве все элементы равны
     * @param data - принимаемый массив
     * @return true - если все эелменты равны, иначе false
     * */
    public boolean mono(boolean[] data) {
        System.out.println(Arrays.toString(data));
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0] != data[i]) {
                return false;
            }
        }
        return result;
    }
}