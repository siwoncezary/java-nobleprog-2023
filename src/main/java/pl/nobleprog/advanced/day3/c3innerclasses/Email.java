package pl.nobleprog.advanced.day3.c3innerclasses;

import java.time.LocalDate;

public class Email {
    private String to;

    private String content;

    private String subject;

    private String udw;

    private Email(String to, String content, String subject, String udw) {
        this.to = to;
        this.content = content;
        this.subject = subject;
        this.udw = udw;
    }

    public static Builder builder() {
        return new Builder();       // dostęp do skladowych klasy wewnetrznej statycznych
    }

    public static class Builder {
        private String to;

        private String content;

        private String subject;

        private String udw;

        private Builder() {
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder subject(String to) {
            this.subject = to;
            return this;
        }

        public Builder content(String to) {
            this.content = to;
            return this;
        }

        public Builder udw(String to) {
            this.udw = to;
            return this;
        }

        public Email build() {
            return new Email(to, content, subject, udw);        // dostęp do skladowej prywatnej klasy zewnętrznej statycznych
        }

    }
}
