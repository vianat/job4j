package ru.job4j.array;
/*
 * Class MatrixCheck проверяет равенство значений в массиве по диагоналям
 * @author Sergei Nikiforov
 * @since 18.08.2019
 * @version 1
 * */
public class MatrixCheck {
    /*
     * проверяет равенство значений в массиве по диагоналям
     * @param data - принимаемый массив
     * @return true - если все элементы по диагоналям равно, иначе false
     * */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean check = data[0][0];

        for (int x = 0, y = 0; x < data.length; x++, y++) {
                if (data[x][y] != check) {
                    return false;
                }
        }
        return result;
    }
}
