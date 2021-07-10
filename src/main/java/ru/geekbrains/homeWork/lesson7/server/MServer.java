package ru.geekbrains.homeWork.lesson7.server;

import java.net.*;
import java.io.*;
import java.util.Vector;

public class MServer {

    private Vector<ClientHandler> clients;

    public MServer() {
        try {
            ServerSocket serv_socket = new ServerSocket(12345);
            clients = new Vector<>();

            //noinspection InfiniteLoopStatement
            while(true) {
                System.out.println("Waiting for a new client!");
                Socket socket = serv_socket.accept();
                ClientHandler cl = new ClientHandler(this, socket);
                add_client(cl);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void add_client(ClientHandler client) {
        clients.add(client);
    }

    public void remove_client(ClientHandler client) {
        clients.remove(client);
    }

    public void broadcastMsg(String msg) {
        for(ClientHandler client: clients) {
            client.sendMsg(msg);
        }
    }

    public void whisperMsg(ClientHandler from, String to, String msg) {

        for (ClientHandler client: clients) {
            if(client.getClientName().equals(to)) {
                client.sendMsg("[W from: " + from.getClientName() + "] " + msg);
                break;
            }
        }
        from.sendMsg("[W to: " + to + "] " + msg);
    }
}
