package pl.nobleprog.advanced.day3.c1io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChatServer {
    public static final int PORT = 9999;
    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.printf("Server started. Listening on port %d\n", PORT);
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            executorService.execute(() -> {
                System.out.printf("Client from %s connected...\n", clientSocket.getInetAddress().toString());
                try (
                        Writer writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        Scanner scanner = new Scanner(new InputStreamReader(clientSocket.getInputStream()))
                        ){
                    writer.write("Hello");
                    writer.flush();
                    String line = "";
                    while((line = scanner.nextLine()) != null){
                        System.out.printf("Message from client: %s\n", line);
                    }
                    System.out.printf("Client from % disconnected from server!", clientSocket.getInetAddress().toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
