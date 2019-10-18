package ui.exceptions;

public class InvalidUserInputException extends RuntimeException {
    public InvalidUserInputException(String e) {
        super(e);
    }

    public InvalidUserInputException() {
        super("Invalid User Input");
    }
}
