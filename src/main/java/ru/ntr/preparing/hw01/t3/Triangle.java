package ru.ntr.preparing.hw01.t3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;

    @Override
    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
