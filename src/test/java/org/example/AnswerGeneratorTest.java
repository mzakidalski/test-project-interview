package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnswerGeneratorTest {
    @Mock
    TimeProvider timeProvider;

    @InjectMocks
    @Spy
    AnswerGenerator answerGenerator;

    @Test
    @DisplayName("generate answer")
    void generateAnswer() {
        assertThat(answerGenerator.generateAnswer(), equalTo("42"));
        assertThat(answerGenerator.generateAnswer(), startsWith("4"));
        assertThat(answerGenerator.generateAnswer(), endsWith("2"));
        verify(answerGenerator, times(3)).generateAnswer();
    }

    @Test
    @DisplayName("generate answers as list")
    void generateAnswerAsList() {
        var answer = answerGenerator.generateListAnswer();
        assertThat(answer, hasSize(4));
        assertThat(answer, contains("42", "is", "the", "answer"));
        assertThat(answer, containsInAnyOrder("answer", "the", "is", "42"));
        verify(answerGenerator, times(1)).generateListAnswer();

    }

    @Test
    @DisplayName("generate answer as array")
    void generateAnswerAsArray() {
        var answer = answerGenerator.generateArrayAnswer();
        assertThat(answer, arrayWithSize(4));
        assertThat(answer, arrayContaining("42", "is", "the", "answer"));
    }

    @Test
    @DisplayName("generate answer throwing exception")
    void generateAnswerThrowingException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> answerGenerator.generateAnswerThrowingAssertions(42));
    }

    @ParameterizedTest
    @CsvSource({
            "ALPHA, 1.2, 'aa'",
            "BETA, 1.3, 'ab'"
    })
    @DisplayName("parametrized test")
    void testMultipleParameters(MyEnum myEnum, float value, String result) {
        assertThat(myEnum, is(not(MyEnum.GAMMA)));
        assertThat(value, is(greaterThan(1.0f)));
        assertThat(result, startsWith("a"));
    }


}