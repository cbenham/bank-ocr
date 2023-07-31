package io.conrad;

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

    @Test
    @Disabled
    public void itReadsAndParsesFileContainingAccountNumbers() {
        var application = new Application();
        var inputReader = new BufferedReader(new StringReader(INPUT));

        var actualAccountNumbers = application.parseAccountNumbers(inputReader);

        assertThat(actualAccountNumbers).isEqualTo("345882865\n345883462");
    }
}
