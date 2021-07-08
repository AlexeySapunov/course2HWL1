package ru.geekbrains.homeWork.lesson7.server;

import java.net.*;
import java.io.*;

public class ClientHandler {

    private DataInputStream  in;
    private DataOutputStream out;
    private String clientName;

    private static int counter = 0;

    public ClientHandler(MServer server, Socket socket) {

        try {
            counter++;
            this.clientName = "user" + counter;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(()-> {

                try {
                    while(true) {
                        String str = in.readUTF();
                        System.out.println("A message from a client: " + str);

                        if(str.equalsIgnoreCase("/end")) {
                            break;
                        }

                        if(str.startsWith("/w")) {
                            String to = str.split(" ")[1];
                            String msg = str.split(" ")[2];
                            server.whisperMsg(this, to, msg);
                        } else {
                            server.broadcastMsg("[" + this.clientName + "] " + str);
                        }
                        out.flush();
                    }
                } catch(IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        out.close();
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        socket.close();
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                    server.remove_client(this);
                }
            }).start();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getClientName() {
        return this.clientName;
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
