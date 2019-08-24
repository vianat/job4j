package ru.job4j.calculator;
/*
* Class Calculator производит вычисления над числами
* @author Sergei Nikiforov
* @since 13.08.2019
* @version 1
* */

public class Calculator {
    /*
    * Сложение чисел
    * @param first - первый аргумент
    * @param second - второй аргумент и т.д.
    * @return результат
    * */
    public static double add(double first, double second) {
        return first + second;
    }
    public double add(double first, double second, double third) {
        return add(first, add(second, third));
    }

    /*
     * Деление 2х чисел
     * @param first - первый аргумент
     * @param second - второй аргумент
     * @return результат
     * */
    public static double div(double first, double second) {
        return first / second;
    }

    /*
     * Умножение 2х чисел
     * @param first - первый аргумент
     * @param second - второй аргумент
     * @return результат
     * */
    public static double multiply(double first, double second) {
        return first * second;
    }
    /*
     * Вычитание 2х чисел
     * @param first - первый аргумент
     * @param second - второй аргумент
     * @return результат
     * */
    public static double subtrack(double first, double second) {
        return first - second;
    }

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}