package com.start.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.in;
import static java.lang.System.out;

public class Server implements Runnable {

    private static ServerSocket server;


    public void setServer() {
        Thread read = new Thread(new ServerService());
        read.start();


        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Server run!");
                ExecutorService ex = Executors.newFixedThreadPool(20);
                while (true) {
                    ex.execute(new ForEx(server.accept()));
                }

            } finally {
                System.out.println("Server close");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public void run() {
        setServer();
    }
}

class ForEx implements Runnable {
    Socket clientSocket;

    public ForEx(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    ServerService serverService = new ServerService();

    @Override
    public void run() {
        if (serverService.getBlackIP().contains(clientSocket.getInetAddress().toString())) {
            out.println(clientSocket.getInetAddress().toString());
            out.println("Server Bad IP");
            try {
                clientSocket.close();
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String word = in.readLine();
            System.out.println(word);
            out.write("Server - Hello, server say, you write -  " + word + "\n");
            out.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {


            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
