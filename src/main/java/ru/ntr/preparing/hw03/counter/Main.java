package ru.ntr.preparing.hw03.counter;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.concurrent.atomic.AtomicLong;

@Log
public class Main {

    private static final int QUANTITY = 1000;

    public static void main(String[] args) {

        Counter counter = new Counter(0);

        Thread increment = new Thread(() -> {
            for (int i = 0; i < QUANTITY; i++) {
                counter.increment();

            }
        });

        Thread decrement = new Thread(() -> {
            for (int i = 0; i < QUANTITY; i++) {
                counter.decrement();
            }
        });

        increment.start();
        decrement.start();

        try {
            increment.join();
            decrement.join();
        } catch (InterruptedException e) {
            log.warning(e.getMessage());
        }

        System.out.println("Inc + Dec = " + counter.get());

    }

}
