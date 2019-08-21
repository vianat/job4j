package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
               result = false;
               break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        //check horizontal line
        //заполянем новый массив (длиной 5) элементами из
        //одной горизонтально строчки входящего массива,
        //в новом проверяем сумму элементов (если все однёрки = сумме 5) возвращем true
        int[] line = new int[5];
        for (int out = 0; out < table.length; out++) {
            for (int in = 0; in < table.length; in++) {
                line[in] = table[out][in];
                //System.out.println(Arrays.toString(line));
            }
            int summLine = 0;
            boolean flag = false;
            for (int x : line) {
                summLine += x;
                if (summLine == 5 ) {
                    flag = true;
                }
            }
            if (flag){
                result = true;
                break;
            }

        }
        //check vertical line
        //тоже самое только работаем с вертикальной строчкой (поменяно in-out местами)
        for (int out = 0; out < table.length; out++) {
            for (int in = 0; in < table.length; in++) {
                line[in] = table[in][out];
                System.out.println(Arrays.toString(line));
            }
            int summLine = 0;
            boolean flag = false;
            for (int x : line) {
                summLine += x;
                if (summLine == 5 ) {
                    flag = true;
                }
            }
            if (flag){
                result = true;
                break;
            }

        }


        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.convert());
    }
}
