package org.example;

import java.util.List;

public class AnswerGenerator {
    public String generateAnswer() {
        return "42";
    }

    public List<String> generateListAnswer() {
        return List.of("42", "is", "the", "answer");
    }

    public String[] generateArrayAnswer() {
        return new String[]{ "42", "is", "the", "answer" };
    }

    public String generateAnswerThrowingAssertions(int input) {
        if (input == 42) {
            throw new IllegalArgumentException("This argument is incorrect");
        }
        return "42";
    }
}
