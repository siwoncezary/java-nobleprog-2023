package pl.nobleprog.advanced.day1.c4factory.task;

public class SMS extends Message{
    private String sourceNumber;

    private String targetNumber;

    public SMS(String content, String sourceNumber, String targetNumber) {
        super(content);
        this.sourceNumber = sourceNumber;
        this.targetNumber = targetNumber;
    }

    public String getSourceNumber() {
        return sourceNumber;
    }

    public String getTargetNumber() {
        return targetNumber;
    }
}
