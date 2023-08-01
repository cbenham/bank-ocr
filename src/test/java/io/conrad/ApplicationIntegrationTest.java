package io.conrad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationIntegrationTest {

    private static final String INPUT = new StringBuilder()
            .append(" _     _  _  _  _  _  _  _ ").append(System.lineSeparator())
            .append(" _||_||_ |_||_| _||_||_ |_ ").append(System.lineSeparator())
            .append(" _|  | _||_||_||_ |_||_| _|").append(System.lineSeparator())
            .append("                           ").append(System.lineSeparator())
            .append(" _     _  _  _  _     _  _ ").append(System.lineSeparator())
            .append(" _||_||_ |_||_| _||_||_  _|").append(System.lineSeparator())
            .append(" _|  | _||_||_| _|  ||_||_ ").append(System.lineSeparator())
            .append("                           ").append(System.lineSeparator())
            .toString();

    private Application application;

    @BeforeEach
    void setup() {
        this.application = new Application();
    }

    @Test
    @Disabled
    public void itReadsAndParsesFileContainingAccountNumbers() {
        var accountNumberOne = "345882865";
        var accountNumberTwo = "345883462";
        var inputReader = new StringReader(INPUT);

        var actual = this.application.parseAccountNumbers(inputReader);

        assertThat(actual).isEqualTo("%s%s%s", accountNumberOne, System.lineSeparator(), accountNumberTwo);
    }
}
