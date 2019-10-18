package ui.exceptions;

public class UserInputNotANumberException extends InvalidUserInputException {
    public UserInputNotANumberException(String e) {
        super(e);
    }

    public UserInputNotANumberException() {
        super("Are you dumb? Enter a number or x please");
    }
}
