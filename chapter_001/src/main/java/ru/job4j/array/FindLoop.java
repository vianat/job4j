package ru.job4j.array;
/*
 * Class FindLoop поиск индекса элемента в массиве
 * @author Sergei Nikiforov
 * @since 18.08.2019
 * @version 1
 * */
public class FindLoop {
    /*
     * возвразает индекс найденного в массиве элемента, -1 если не найден
     * @param bound - длинна создаваемого массива
     * @param el - искомый элемент
     * @return индекс элемента в массиве или -1
     * */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
    /*
     * возвразает индекс найденного в массиве в диапазоне "старт-финиш" элемента, -1 если не найден
     * @param bound - длинна создаваемого массива
     * @param start - начальный индекс диапазона
     * @param finish - последний индекс диапазона
     * @param el - искомый элемент
     * @return индекс элемента в массиве или -1
     * */
    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int i = start; i < data[finish]; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        for (int min = 0; min < data.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < data.length; j++) {
                if (data[j] < data[least]) {
                    least = j;
                }
            }
            int tmp = data[min];
            data[min] = data[least];
            data[least] = tmp;
        }
        return data;
    }
}