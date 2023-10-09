package pl.nobleprog.advanced.day1.c4factory.task;

public class FactoryTask {
    public static void main(String[] args) {
        Message message = createMessage("email;Zebranie;Zebranie odbędzie się w sali 12 o godzinie 12:00;szef@firma.pl;marek@firma.pl");
    }

    // zdefiniuj metodę wytwórczą, która na podstawie łańcucha z surowymi danymi tworzy:
    // - dla łańcucha o postaci: "email; temat wiadomości;treść wiadomości;adres źródłowy;adres docelowy" instancję klasy Email
    // - dla łańcucha o postaci: "sms;treść wiadomości;numer źródłowy;numer docelowy" instancję klasy SMS
    // Przykłady wywołamnia:
    // Message m1 = createMessage("email;Zebranie;Zebranie odbędzie się w sali 12 o godzinie 12:00;szef@firma.pl;marek@firma.pl");
    public static Message createMessage(String data){
        throw new RuntimeException("Not implemented!");
    }

}
