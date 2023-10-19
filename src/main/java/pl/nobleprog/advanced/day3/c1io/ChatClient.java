package pl.nobleprog.advanced.day3.c1io;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements AutoCloseable{
    private final Socket socket;

    private final PrintWriter writer;

    private final Scanner scanner;


    public ChatClient(Socket socket) throws IOException {
        this.socket = socket;
        writer = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
        scanner = new Scanner(new InputStreamReader(socket.getInputStream()));
    }

    public Socket getSocket() {
        return socket;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void close(){
        if (scanner != null) {
            scanner.close();
        }
        if (writer != null) {
            writer.close();
        }
    }
}
