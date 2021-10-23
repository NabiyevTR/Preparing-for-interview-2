package ru.ntr.preparing.hw03.pingpong;

import lombok.SneakyThrows;

public class Main {

    private static final int QUANTITY = 5;

    @SneakyThrows
    public static void main(String[] args) {

        PingPong pingPong = new PingPong();

        Thread ping = new Thread(() -> {
            for (int i = 0; i < QUANTITY; i++) {
                pingPong.printPing();
            }
        });

        Thread pong = new Thread(() -> {
            for (int i = 0; i < QUANTITY; i++) {
                pingPong.printPong();
            }
        });

        ping.start();
        pong.start();


    }
}
