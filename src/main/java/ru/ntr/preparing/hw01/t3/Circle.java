package ru.ntr.preparing.hw01.t3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circle implements Shape {

    private double r;

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}
