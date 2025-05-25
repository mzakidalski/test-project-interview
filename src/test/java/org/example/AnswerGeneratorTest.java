package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AnswerGeneratorTest {

    @Test
    @DisplayName("generate answer")
    void generateAnswer() {
        var answerGenerator = new AnswerGenerator();
        assertThat(answerGenerator.generateAnswer(), equalTo("42"));
        assertThat(answerGenerator.generateAnswer(), startsWith("4"));
        assertThat(answerGenerator.generateAnswer(), endsWith("2"));
    }

    @Test
    @DisplayName("generate answers as list")
    void generateAnswerAsList() {
        var answerGenerator = new AnswerGenerator();
        var answer = answerGenerator.generateListAnswer();
        assertThat(answer, hasSize(4));
        assertThat(answer, contains("42", "is", "the", "answer"));
        assertThat(answer, containsInAnyOrder("answer", "the", "is", "42"));
    }

    @Test
    @DisplayName("generate answer as array")
    void generateAnswerAsArray() {
        var answerGenerator = new AnswerGenerator();
        var answer = answerGenerator.generateArrayAnswer();
        assertThat(answer, arrayWithSize(4));
        assertThat(answer, arrayContaining("42", "is", "the", "answer"));
    }

    @Test
    @DisplayName("generate answer throwing exception")
    void generateAnswerThrowingException() {
        var answerGenerator = new AnswerGenerator();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> answerGenerator.generateAnswerThrowingAssertions(42));
    }


}