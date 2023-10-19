package pl.nobleprog.advanced.day3.c2nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // NIO class: Path, Files
        Path pathToFile = Paths.get("..\\home\\..\\folder\\.\\ex1txt");
        System.out.println(pathToFile.getFileName());
        System.out.println(pathToFile.getParent());
        System.out.println(pathToFile.getRoot());
        System.out.println(pathToFile.isAbsolute());
        System.out.println(pathToFile.normalize());
        pathToFile = Paths.get("ex1.txt");
        //Files.copy(System.in, pathToFile, StandardCopyOption.REPLACE_EXISTING);
        Path tempFile = Files.createTempFile("java", "advanced");
        System.out.println(tempFile);
        Files.writeString(tempFile, "Hello\nfrom temp file!");
        List<String> strings = Files.readAllLines(tempFile);
        System.out.println(strings);
        try (
                var stream = Files.lines(tempFile);
        ) {
            stream
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        }
        Path path = Paths.get("demo.txt");
        try(
            var writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
        ){
            saveToWriter(writer);
        }
        // utworz katalog temp w biezacym folderze
        // skopiuj do utworzonego katalogu plik demo.txt
        // usun z biezacego katalogu plik out.txt
        Path dir = Paths.get("temp");
        try {
            Files.createDirectory(dir);
        }catch (FileSystemException e){
            System.out.println("Katalog juz istnieje");
        }
        Path source = Path.of("demo.txt");
        var target = dir.resolve(source);
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        try {
            Files.delete(Path.of("out.txt"));
        } catch (NoSuchFileException e){
            System.out.println("Brak pliku do usuniecia!");
        }
    }

    public static void saveToWriter(BufferedWriter writer){
        IntStream.range(0,100).forEach(i -> {
            try {
                writer.write("ABCD\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
