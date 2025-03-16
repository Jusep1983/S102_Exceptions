package level3.exceptions;

public class IncorrectPersonNameException extends RuntimeException {
    public IncorrectPersonNameException(String message) {
        super(message);
    }
}
