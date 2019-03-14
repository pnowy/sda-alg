package pl.sda.programming.introduction;

public class NegativeAmountRecordException extends InvalidRecordException {

    public NegativeAmountRecordException() {
        super("The money amount is negative! Fix it!");
    }
}
