package pl.nobleprog.advanced.day1.c4factory.task;

public class Email extends Message{
    private String subject;
    private String from;
    private String to;

    public Email(String content, String subject, String from, String to) {
        super(content);
        this.subject = subject;
        this.from = from;
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
