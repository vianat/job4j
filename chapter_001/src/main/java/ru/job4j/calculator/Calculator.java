package ru.job4j.calculator;

/*
* Class Calculator производит вычисления над числами
* @author Sergei Nikiforov
* @since 13.08.2019
* @version 1
* */


public class Calculator {

    /*
    * Сложение 2х чисел
    * @param first - первый аргумент
    * @param second - второй аргумент
    * @return результат
    * */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /*
     * Деление 2х чисел
     * @param first - первый аргумент
     * @param second - второй аргумент
     * @return результат
     * */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /*
     * Умножение 2х чисел
     * @param first - первый аргумент
     * @param second - второй аргумент
     * @return результат
     * */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + " * " + second + " = " + result);
    }
    /*
     * Вычитание 2х чисел
     * @param first - первый аргумент
     * @param second - второй аргумент
     * @return результат
     * */
    public static void subtrack(double first, double second) {
        double result =  first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}