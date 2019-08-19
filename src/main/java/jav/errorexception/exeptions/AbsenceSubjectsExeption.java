package jav.errorexception.exeptions;

public class AbsenceSubjectsExeption extends Exception {
    public AbsenceSubjectsExeption(String message) {
        super(message);
    }

    public AbsenceSubjectsExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
