package io.conrad.parsing;

import io.conrad.account.AccountNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class AccountLinesParser {

    private static final int LINES_PER_ACCOUNT_NUMBER = 3;

    private final AccountNumberParser accountNumberParser;

    public AccountLinesParser(AccountNumberParser accountNumberParser) {
        this.accountNumberParser = accountNumberParser;
    }

    public List<AccountNumber> parseLines(Reader reader) {
        var bufferedReader = new BufferedReader(reader);
        var entry = this.readEntry(bufferedReader);
        return List.of(this.accountNumberParser.parseAccountNumber(entry));
    }

    private String readEntry(BufferedReader bufferedReader) {
        var buffer = new StringBuilder();
        for (int lineNumber = 0; lineNumber < LINES_PER_ACCOUNT_NUMBER; lineNumber++) {
            buffer.append(this.readSingleLine(bufferedReader));
            buffer.append(System.lineSeparator());
        }
        return buffer.toString();
    }

    private String readSingleLine(BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
