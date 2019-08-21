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
        for (int i = 1; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[data.length -1][0] != data[data.length - 1 - i][i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
