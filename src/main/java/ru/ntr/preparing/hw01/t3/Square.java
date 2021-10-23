package ru.ntr.preparing.hw01.t3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Square implements Shape {

    private double a;

    @Override
    public double getArea() {
        return a * a;
    }
}
