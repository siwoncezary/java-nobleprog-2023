package pl.nobleprog.advanced.day3.c2nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
}
