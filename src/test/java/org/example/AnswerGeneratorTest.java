package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;

@ExtendWith(MockitoExtension.class)
class AnswerGeneratorTest {

    @Test
    void generateAnswer() {
        var answerGenerator = new AnswerGenerator();
        assertThat(answerGenerator.generateAnswer(), equalTo("42"));
    }
}