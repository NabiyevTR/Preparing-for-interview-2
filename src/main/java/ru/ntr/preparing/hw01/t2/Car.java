package ru.ntr.preparing.hw01.t2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
abstract class Car implements Movable, Openable {
    public Engine engine;
    private String color;
    private String name;

    @Override
    public void start() {
        System.out.println(name + " is starting");
    }

    @Override
    public void move() {
        System.out.println(name + " is moving");
    }

    @Override
    public void stop() {
        System.out.println(name + " is stopping");
    }


    @Override
    public void open() {
        System.out.println(name + " is opened");
    }

    @Override
    public void close() {
        System.out.println(name + " is closed");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
