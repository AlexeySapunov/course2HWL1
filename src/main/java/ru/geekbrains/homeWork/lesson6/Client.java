package ru.geekbrains.homeWork.lesson6;

import java.io.*;
import java.net.*;

    public class Client {
        public static void main(String[] args) throws IOException {
            Client1 client1 = new Client1();
            System.out.println("Client started. Connecting to localhost: 1111");

            new Thread(() -> {
                try {
                    client1.readMSG();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    client1.sendMSG();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    class Client1 {
        Socket socket;
        BufferedReader in;
        PrintWriter out;
        BufferedReader console;
        String userMSG, serverMSG;

        public Client1() throws IOException {
            socket = new Socket("localhost",1111);
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            console = new BufferedReader(new InputStreamReader(System.in));
        }

        void sendMSG() throws IOException {
            while (true) {
                if ((userMSG = console.readLine()) != null) {
                    out.println(userMSG);
                    if (userMSG.equalsIgnoreCase("close") || userMSG.equalsIgnoreCase("exit")) close();
                    break;
                }
            }
        }

        void readMSG() throws IOException {
            //noinspection InfiniteLoopStatement
            while (true) if ((serverMSG = in.readLine()) != null) {
                System.out.println(serverMSG);
            }
        }

        void close() throws IOException {
            out.close();
            in.close();
            console.close();
            socket.close();
        }
    }
