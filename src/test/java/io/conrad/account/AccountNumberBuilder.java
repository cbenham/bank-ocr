package io.conrad.account;

import java.util.Arrays;
import java.util.List;

public final class AccountNumberBuilder {

    private List<AccountNumberCharacter> accountNumberCharacters = Arrays.asList(
            AccountNumberCharacterBuilder.builder().withCharacter('1').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('9').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('2').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('8').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('3').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('7').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('4').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('5').build(),
            AccountNumberCharacterBuilder.builder().withCharacter('6').build()
    );

    private AccountNumberBuilder() {
    }

    public static AccountNumber buildFromStringOfCharacters(String accountNumber) {
        var characters = accountNumber.chars()
                .mapToObj(value -> (char) value)
                .map(value -> AccountNumberCharacterBuilder.builder().withCharacter(value))
                .map(AccountNumberCharacterBuilder::build).toList();
        return AccountNumberBuilder.builder().withAccountNumberCharacters(characters).build();
    }

    public static AccountNumberBuilder builder() {
        return new AccountNumberBuilder();
    }

    public AccountNumberBuilder withAccountNumberCharacters(List<AccountNumberCharacter> accountNumberCharacters) {
        this.accountNumberCharacters = accountNumberCharacters;
        return this;
    }

    public AccountNumber build() {
        return new AccountNumber(this.accountNumberCharacters);
    }
}
