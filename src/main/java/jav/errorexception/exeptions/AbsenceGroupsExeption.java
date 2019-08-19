package jav.errorexception.exeptions;

public class AbsenceGroupsExeption extends Exception {
    public AbsenceGroupsExeption(String message) {
        super(message);
    }

    public AbsenceGroupsExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AbsenceGroupsExeption(Throwable cause) {
        super(cause);
    }
}
