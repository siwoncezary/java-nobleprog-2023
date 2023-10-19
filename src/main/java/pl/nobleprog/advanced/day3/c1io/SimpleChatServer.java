package pl.nobleprog.advanced.day3.c1io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChatServer {
    public static final int PORT = 9999;
    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.printf("Server started. Listening on port %d\n", PORT);
        List<ChatClient> clients = Collections.synchronizedList(new ArrayList<>());
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            executorService.execute(() -> {
                ThreadLocal<Socket> currentSocket = new ThreadLocal<>();
                currentSocket.set(clientSocket);
                System.out.printf("Client from %s connected...\n", currentSocket.get().getInetAddress().toString());
                try (
                        ChatClient chatClient = new ChatClient(clientSocket);
                        ){
                    clients.add(chatClient);
                    String address = currentSocket.get().getInetAddress().toString();
                    while(chatClient.getScanner().hasNext()){
                        String message =  chatClient.getScanner().next();
                        System.out.printf("Message from client: %s\n", message);
                        clients.forEach(c -> {
                            c.getWriter().println(message);
                            c.getWriter().flush();
                        });
                    }
                    System.out.printf("Client from %s disconnected from server!", address);
                    clients.remove(chatClient);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
