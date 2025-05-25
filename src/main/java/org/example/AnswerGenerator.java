package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

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
}
