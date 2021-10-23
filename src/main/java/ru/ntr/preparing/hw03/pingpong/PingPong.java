package ru.ntr.preparing.hw03.pingpong;

import lombok.extern.java.Log;


@Log
public class PingPong {

    private static final String PING = "ping";
    private static final String PONG = "pong";

    private String state = PONG;

    public synchronized void printPing() {
        while (state.equals(PING)) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.warning(e.getMessage());
            }
        }
        System.out.println(PING);
        state = PING;
        notify();
    }

    public synchronized void printPong() {
        while (state.equals(PONG)) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.warning(e.getMessage());
            }
        }
        System.out.println(PONG);
        state = PONG;
        notify();
    }
}
