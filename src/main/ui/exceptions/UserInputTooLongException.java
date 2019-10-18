package ui.exceptions;

public class UserInputTooLongException extends InvalidUserInputException {
    public UserInputTooLongException(String e) {
        super(e);
    }

    public UserInputTooLongException() {
        super("Please limit your long ass input under 10 characters or less, or we will blow up your computer");
    }
}
