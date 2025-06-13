package org.build_patterns.builder;

public class Main {
    public static void main(String[] args) {
        AnswerFromDateForm answer = new AnswerFromDateForm.AnswerBuilder()
                .setDay(12)
                .setMonth(3)
                .setYear(2024)
                .get();
        System.out.println(answer);
    }
}
