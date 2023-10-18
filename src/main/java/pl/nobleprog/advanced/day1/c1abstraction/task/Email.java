package pl.nobleprog.advanced.day1.c1abstraction.task;

public class Email extends Message{
    public Email(String content) {
        super(content);
    }

    @Override
    public void send(AbstractMessageSender sender) {
        if (sender instanceof EmailSender){
            sender.sendMessage(this);
        }
    }
}
