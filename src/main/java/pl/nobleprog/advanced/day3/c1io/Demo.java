package pl.nobleprog.advanced.day3.c1io;

import java.io.*;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException {
        // abstract binary streams: InputStream, OutputStream
        //  abstractBinaryStream();
        // stream decorators: BufferedInputStream, BufferedInputStream
        // bufferedInputStream();
        // concrete binary streams: FileInputStream, FileOutputStream
        //   fileInputStream();
        // abstract character streams: Reader, Writer

        // character stream decorators: BufferedReader, BufferedWriter
        System.out.println(Reader(22));
        // concrete character streams: FileReader, FileWriter
    }

    public static int Reader(int rowNumber){

        try (
                Reader in = new FileReader("./ex1.txt");
                BufferedReader reader = new BufferedReader(in);
        ){
            String line = null;
            int counter = 1;
            while((line = reader.readLine()) != null){
                String[] tokens = line.split("\\s");
                String last = tokens[tokens.length - 1];
                try {
                    int number = Integer.parseInt(last);
                    if (rowNumber == number){
                        return counter;
                    }

                } catch (NumberFormatException e){

                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public static void abstractBinaryStream() throws IOException {
        InputStream in = System.in;
        byte[] buf= new byte[10];
        int len = in.read(buf);
        for(int i = 0; i < len; i++) {
            System.out.println((char) buf[i]);
        }
    }

    public static void fileInputStream() throws IOException {
        InputStream in = new FileInputStream("./data.txt");
        byte[] buf = new byte[1024];
        int len = -1;
        while((len = in.read(buf)) != -1){
            for(int i = 0; i < len; i++) {
                System.out.print((char) buf[i]);
            }
            System.out.println();
        }
        in.close();
    }

    public static void bufferedInputStream(){
        try (
            InputStream fileStream = new FileInputStream("./data.txt");
            BufferedInputStream in = new BufferedInputStream(fileStream);
        ) {
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print((char) buf[i]);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
