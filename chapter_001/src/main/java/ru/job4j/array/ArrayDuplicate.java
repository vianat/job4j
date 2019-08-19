package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
//        System.out.println(Arrays.toString(array));
        int count = 0;
        int length = array.length;

        for (int out = 0; out < length; out++) {
            for (int in = out + 1; in < length; in++) {
                if (array[out].equals(array[in])) {

                    System.out.println(array[out] + "-" + array[in] + "--");
                    System.out.println(Arrays.toString(array));
                    array[in] = array[length - 1];
                    System.out.println(Arrays.toString(array));
                    length--;   // уменьшаем длину массива
                    in--;       // возвращаемся
                    count++;    // счётчик итогового среза увеличиваем
                }
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(array));
        return Arrays.copyOf(array, array.length - count);
    }
}
