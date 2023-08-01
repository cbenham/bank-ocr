package io.conrad;

import io.conrad.format.AccountNumberFormatter;
import io.conrad.parsing.AccountLinesParser;
import io.conrad.parsing.AccountNumberParser;

import java.io.Reader;

public class Application {

    private final AccountLinesParser accountLinesParser;
    private final AccountNumberFormatter accountNumberFormatter;

    public Application() {
        this(new AccountLinesParser(new AccountNumberParser()), new AccountNumberFormatter());
    }

    public Application(AccountLinesParser accountLinesParser, AccountNumberFormatter accountNumberFormatter) {
        this.accountLinesParser = accountLinesParser;
        this.accountNumberFormatter = accountNumberFormatter;
    }

    public String parseAccountNumbers(Reader reader) {
        var accountNumbers = this.accountLinesParser.parseLines(reader);
        return this.accountNumberFormatter.format(accountNumbers);
    }

    public static void main(String[] args) {
    }
}
