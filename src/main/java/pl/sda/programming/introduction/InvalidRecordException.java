package pl.sda.programming.introduction;

public class InvalidRecordException extends RuntimeException {

    public InvalidRecordException(String reason) {
        super(reason);
    }

}
