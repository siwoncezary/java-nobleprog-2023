package pl.nobleprog.advanced.day1.c1abstraction.task;

public class EmailSender implements AbstractMessageSender{
    @Override
    public void sendMessage(Message message) {
        System.out.println(message);
    }
}
