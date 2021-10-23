package ru.ntr.preparing.hw01.t2;

class LightWeightCar extends Car {

    public LightWeightCar(String color) {
        super(new LightWeightCarEngine(), color, "Light weight car");
    }
}
