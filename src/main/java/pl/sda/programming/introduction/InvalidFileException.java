package pl.sda.programming.introduction;

import java.io.IOException;

public class InvalidFileException extends IOException {

    public InvalidFileException(String reason) {
        super(reason);
    }

}
