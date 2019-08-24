package ru.job4j.condition;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * Формула.
     * (a + b + c) / 2
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return полуперимента.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     * @return
     */
    private boolean exist(double a, double c, double b) {
        if ((a + b > c) & (a + c > b) & (b + c > a)) {
            return true;
        }
        return false;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     * Формула.
     * √ p *(p - a) * (p - b) * (p - c)
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area(Triangle tri) {
        double rsl = -1;
        double ab = this.first.distance(this.second);
        double bc = this.second.distance(tri.third);
        double ac = tri.first.distance(tri.third);
        double p = period(ab, bc, ac);
        if (this.exist(ab, bc, ac)) {
            rsl = Math.sqrt(p*(p - ab)*(p - bc)*(p - ac));
        }
        return rsl;
    }
}
