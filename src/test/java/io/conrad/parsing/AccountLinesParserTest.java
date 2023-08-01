package io.conrad.parsing;

import io.conrad.account.AccountNumberBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountLinesParserTest {

    private static final String LINE_ONE = new StringBuilder()
            .append(" _     _  _  _  _  _  _  _ ").append(System.lineSeparator())
            .append(" _||_||_ |_||_| _||_||_ |_ ").append(System.lineSeparator())
            .append(" _|  | _||_||_||_ |_||_| _|").toString();

    private static final String BLANK_LINE = String.format("%s                           ", System.lineSeparator());

    @Mock
    private AccountNumberParser mockAccountNumberParser;

    private AccountLinesParser parser;

    @BeforeEach
    void setup() {
        this.parser = new AccountLinesParser(this.mockAccountNumberParser);
    }

    @Test
    void itParsesASingleLine() {
        var reader = new StringReader(LINE_ONE + BLANK_LINE);
        var accountNumber = AccountNumberBuilder.buildFromStringOfCharacters("345882865");
        when(this.mockAccountNumberParser.parseAccountNumber(LINE_ONE)).thenReturn(accountNumber);

        var actual = this.parser.parseLines(reader);

        assertThat(actual).containsExactly(accountNumber);
    }
}