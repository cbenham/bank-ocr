package io.conrad;

import io.conrad.account.AccountNumber;
import io.conrad.parsing.AccountLinesParser;

import java.io.Reader;
import java.util.List;

public class Application {

    private final AccountLinesParser accountLinesParser;

    public Application() {
        this(new AccountLinesParser());
    }

    public Application(AccountLinesParser accountLinesParser) {

        this.accountLinesParser = accountLinesParser;
    }

    public List<AccountNumber> parseAccountNumbers(Reader reader) {
        return this.accountLinesParser.parseLines(reader);
    }

    public static void main(String[] args) {
    }
}
