package jav.errorexception.exeptions;

public class AbsenceStdentExeption extends Exception {

    public AbsenceStdentExeption(String message) {
        super(message);
    }

    public AbsenceStdentExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
