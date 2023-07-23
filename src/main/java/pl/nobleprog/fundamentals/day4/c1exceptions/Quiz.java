package pl.nobleprog.fundamentals.day4.c1exceptions;

import java.util.List;

public class Quiz {
    private List<String> correctOptions;
    private List<String> incorrectOptions;
    private String question;

    public Quiz(List<String> correctOptions, List<String> incorrectOptions, String question) {
        this.correctOptions = correctOptions;
        this.incorrectOptions = incorrectOptions;
        this.question = question;
    }

    public static Quiz of (List<String> incorrectOptions, List<String> coorectOptions, String question){
        // ... uzupełnij kod
        return new Quiz(incorrectOptions, coorectOptions, question);
    }
}
