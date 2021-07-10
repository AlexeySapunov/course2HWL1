package ru.geekbrains.homeWork.lesson7;

import ru.geekbrains.homeWork.lesson7.client.Client;
import ru.geekbrains.homeWork.lesson7.server.MServer;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        new Thread(MServer::new).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        new Thread(() -> Application.launch(Client.class, args)).start();
    }
}
