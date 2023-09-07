package pl.nobleprog.advanced.day3.c2nio;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // NIO class: Path, Files
        downloadFile(
                "http://download.geonames.org/export/dump/readme.txt",
                Path.of("readme.txt"));
        Thread.sleep(1000);

        channelDemo();
    }

    public static void readFile(Path path) throws IOException {
        Files
                .lines(path)
                .forEach(System.out::println);
    }

    public static void saveFile() throws IOException {
        Path path = Path.of("data.txt");
        Files.write(path, Stream.generate(() -> "abcd").limit(100).toList());
    }

    public static void createTempFile() throws IOException {
        final Path path = Files.createTempFile("data", ".txt");
        System.out.println(path);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            IntStream.range(0, 100).forEach(i -> {
                try {
                    writer.write("AAAA");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static void downloadFile(String stringUrl, Path destinatonPath) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(stringUrl))
                .GET()
                .build();
        client
                .sendAsync(
                        request,
                        HttpResponse.BodyHandlers.ofFile(
                                destinatonPath,
                                StandardOpenOption.CREATE,
                                StandardOpenOption.WRITE)
                )
                .whenComplete((r, e) -> {
                    System.out.printf("File %s download completed.", r.body());
                });
    }

    public static void channelDemo() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("readme.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        // other channels
        // - DatagramChannel (UDP protocol)
        // - SocketChannel (TCP protocol)
        // - ServerSocketChannel (TCP protocol)

        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = 0;
        while ((bytesRead = inChannel.read(buf)) != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        byte[] bytesWrite = "END OF FILE\n".getBytes();
        int written = inChannel.write(ByteBuffer.wrap(bytesWrite));
        System.out.println("Bytes written: " + written);
        aFile.close();
    }
}
