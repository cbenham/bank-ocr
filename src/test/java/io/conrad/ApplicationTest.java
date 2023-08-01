package io.conrad;

import io.conrad.account.AccountNumberBuilder;
import io.conrad.parsing.AccountLinesParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.StringReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {

    @Mock
    private AccountLinesParser mockAccountLinesParser;

    private Application application;

    @BeforeEach
    void setup() {
        this.application = new Application(this.mockAccountLinesParser);
    }

    @Test
    void itParsesAccountNumbers() {
        var reader = new StringReader("faked account lines - this Reader isn't read because it's passed to the mock");
        var lineOneAccountNumber = AccountNumberBuilder.buildFromStringOfCharacters("345882865");
        when(this.mockAccountLinesParser.parseLines(reader)).thenReturn(List.of(lineOneAccountNumber));

        var actual = this.application.parseAccountNumbers(reader);

        assertThat(actual).containsExactly(lineOneAccountNumber);
    }

}
