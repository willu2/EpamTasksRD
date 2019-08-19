package jav.errorexception.exeptions;

public class WrongMarkExeption extends Exception {
    public WrongMarkExeption(String message) {
        super(message);
    }

    public WrongMarkExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
