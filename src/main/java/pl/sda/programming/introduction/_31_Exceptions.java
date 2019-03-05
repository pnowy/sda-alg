package pl.sda.programming.introduction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

final class _31_Exceptions {

    public static void main(String[] args) {

        try {
            new FileInputStream("sasdasda.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
