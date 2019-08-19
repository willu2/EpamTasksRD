package jav.errorexception.exeptions;

public class AbsenceFacultyExeption extends Exception {

    public AbsenceFacultyExeption(String message) {
        super(message);
    }

    public AbsenceFacultyExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AbsenceFacultyExeption(Throwable cause) {
        super(cause);
    }
}
