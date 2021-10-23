package ru.ntr.preparing.hw01.t3;

public class Main {

    public static void main(String[] args) {

        Shape square = new Square(1.0);
        Shape circle = new Circle(1.0);
        Shape triangle = new Triangle(1.0, 1.0, 1.0);

        System.out.printf("Площадь квадрата: %.2f \n", square.getArea());
        System.out.printf("Площадь круга: %.2f \n", circle.getArea());
        System.out.printf("Площадь треугольника: %.2f \n", triangle.getArea());


    }
}
