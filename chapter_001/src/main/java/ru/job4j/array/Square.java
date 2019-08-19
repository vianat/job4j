package ru.job4j.array;
/*
 * Class Square возводит все числа в массиве в квадрат
 * @author Sergei Nikiforov
 * @since 18.08.2019
 * @version 1
 * */
public class Square {
    /*
     * возводит в квадрат каждый элемент массива
     * @param bound - длинна создаваемого массива
     * @return результат, массив с квадратами чисел
     * */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0, x = 1; i < bound; i++, x++) {
            rst[i] = x * x;
        }
        return rst;
    }
}
