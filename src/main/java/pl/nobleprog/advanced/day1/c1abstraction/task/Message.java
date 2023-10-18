package pl.nobleprog.advanced.day1.c1abstraction.task;

public abstract class Message {
    private String content;
    public Message(String content) {
        this.content = content;
    }

    abstract public void send(AbstractMessageSender sender);

    public String getContent() {
        return content;
    }
}
