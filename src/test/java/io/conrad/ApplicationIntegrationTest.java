package io.conrad;

import io.conrad.account.AccountNumberBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationIntegrationTest {

    private static final String INPUT =
            """
                    _     _  _  _  _  _  _  _
                    _||_||_ |_||_| _||_||_ |_
                    _|  | _||_||_||_ |_||_| _|

                    _     _  _  _  _     _  _ \s
                    _||_||_ |_||_| _||_||_  _|
                    _|  | _||_||_| _|  ||_||_\s""".indent(1);

    private Application application;

    @BeforeEach
    void setup() {
        this.application = new Application();
    }

    @Test
    @Disabled
    public void itReadsAndParsesFileContainingAccountNumbers() {
        var inputReader = new StringReader(INPUT);
        var firstAccountNumber = AccountNumberBuilder.buildFromStringOfCharacters("345882865");
        var secondAccountNumber = AccountNumberBuilder.buildFromStringOfCharacters("345883462");

        var actualAccountNumbers = this.application.parseAccountNumbers(inputReader);

        assertThat(actualAccountNumbers).containsExactly(firstAccountNumber, secondAccountNumber);
    }
}
