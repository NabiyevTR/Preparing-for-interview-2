package ru.ntr.preparing.hw01.t2;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Car lorry = new Lorry("green");
        Car lightWeightCar = new LightWeightCar("red");

        List<Car> cars = Arrays.asList(lorry, lightWeightCar);

        cars.forEach( c -> {
            c.close();
            c.start();
            c.move();
            c.stop();
            c.open();
        });

    }
}



