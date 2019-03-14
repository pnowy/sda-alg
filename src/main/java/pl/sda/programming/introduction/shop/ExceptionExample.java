package pl.sda.programming.introduction.shop;

import com.google.common.collect.Lists;
import pl.sda.programming.introduction.InvalidFileException;
import pl.sda.programming.introduction.InvalidRecordException;

import java.util.List;

public class ExceptionExample {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("A", "B", "C");
        try {
            reviewList(list);
        } catch (InvalidFileException e) {
            System.out.println("Dane wejściowe niepoprawne! Powód: " + e.getMessage());
        }

    }


    private static void reviewList(List<String> list) throws InvalidFileException {
        for (int i = 0; i < list.size(); i++) {
            String currentElement = list.get(i);
            if (currentElement.equals("B")) {
                throw new InvalidFileException("The element is incorrect: " + currentElement);
            }
        }
    }

}
