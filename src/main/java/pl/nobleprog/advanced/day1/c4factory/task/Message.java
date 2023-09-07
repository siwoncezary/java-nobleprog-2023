package pl.nobleprog.advanced.day1.c4factory.task;

public abstract class Message {
    private String content;

    public Message(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
