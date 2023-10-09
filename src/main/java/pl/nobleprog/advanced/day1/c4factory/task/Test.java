package pl.nobleprog.advanced.day1.c4factory.task;

public class Test {
    public static void test(Object message){
        if (message instanceof Email){
            System.out.println("Test 11 passed");
            Email email = (Email) message;
            if ("Zebranie".equals(email.getSubject()) && "szef@firma.pl".equals(email.getFrom()) && "marek@firma.pl".equals(email.getTo())){
                System.out.println("Test 12 passed");
            } else {
                System.out.println("Test 12 failed: invalid data");
            }
        } else {
            System.out.println("Test 11 failed: invalid instance type");
        }
        message = FactoryTask.createMessage("sms;Która godzina?;111111111;111111122");
        if (message instanceof SMS){
            System.out.println("Test 11 passed");
            SMS sms = (SMS) message;
            if ("111111111".equals(sms.getSourceNumber()) && "111111122".equals(sms.getTargetNumber()) && "Która godzina?".equals(sms.getContent())){
                System.out.println("Test 22 passed");
            } else {
                System.out.println("Test 22 failed: invalid data");
            }
        } else {
            System.out.println("Test 21 failed: invalid instance type");
        }
    }
}
