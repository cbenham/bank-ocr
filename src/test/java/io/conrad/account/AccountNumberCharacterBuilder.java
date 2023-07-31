package io.conrad.account;

public final class AccountNumberCharacterBuilder {

    private char character = '1';

    private AccountNumberCharacterBuilder() {
    }

    public static AccountNumberCharacterBuilder builder() {
        return new AccountNumberCharacterBuilder();
    }

    public AccountNumberCharacterBuilder withCharacter(char character) {
        this.character = character;
        return this;
    }

    public AccountNumberCharacter build() {
        return new AccountNumberCharacter(this.character);
    }
}
