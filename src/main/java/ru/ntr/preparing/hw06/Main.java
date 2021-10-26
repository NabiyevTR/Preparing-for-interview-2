package ru.ntr.preparing.hw06;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        Server server = new Server();
        server.start();

    }
}
