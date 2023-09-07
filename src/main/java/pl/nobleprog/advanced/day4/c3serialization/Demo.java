package pl.nobleprog.advanced.day4.c3serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;



public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Jackson XML serializer
        // serialization and deserialization
        System.out.println("Serializing object:");
        serialize(new Book(null, 2022, List.of("Bloch","Freeman")), "books.ser");
        System.out.println("Deserializing object:");
        Book book = (Book) deserialize("books.ser");
        System.out.println(book);
        System.out.println("Serializing book to JSON:");
        String s = serializeToJSON(book);
        System.out.println(s);
        System.out.println("Deserialized book from JSON:");
        Book obj = deserializeBookFromJson(s);
        System.out.println(obj);
        System.out.println(createJson());
        System.out.println(serializeToXML(book));
        parseJson(s);
    }


    public static void serialize(Object object, String filename) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(object);
        output.flush();
        output.close();
    }

    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        final Object o = input.readObject();
        input.close();
        return o;
    }

    public static String serializeToJSON(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter output = new StringWriter();
        mapper.writeValue(output, object);
        return output.getBuffer().toString();
    }

    public static Book deserializeBookFromJson(String input) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        final Book book = mapper.readValue(input, Book.class);
        return book;
    }

    public static String createJson(){
        ObjectMapper mapper = new ObjectMapper();
        final ObjectNode node = mapper.createObjectNode();
        node.put("title", "Json");
        node.put("editionYear", 2020);
        node.put("created", LocalDateTime.now().toString());
        return node.toString();
    }

    public static String serializeToXML(Book book) throws IOException {
        XmlMapper mapper = new XmlMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, book);
        return writer.getBuffer().toString();
    }

    public static void parseJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        final JsonNode tree = mapper.readTree(json);
        for(var child: tree){
            System.out.println(child);
        }
        for (Iterator<String> it = tree.fieldNames(); it.hasNext(); ) {
            var name = it.next();
            System.out.println(name);
        }
        for(var entry: tree.properties()){
            System.out.format("%25s: %-25s\n", entry.getKey(), entry.getValue().toString());
            if (entry.getValue().isArray()){
                final List<JsonNode> list = StreamSupport.stream(entry.getValue().spliterator(), false).toList();
                System.out.println(list);
            }
        }
    }
}
