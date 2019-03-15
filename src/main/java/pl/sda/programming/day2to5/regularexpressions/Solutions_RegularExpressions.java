package pl.sda.programming.day2to5.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solutions_RegularExpressions implements Task_RegularExpressions {
    @Override
    public boolean isPeselValid(String pesel) {
        Matcher matcher = Pattern.compile("^\\d{11}$").matcher(pesel);
        return matcher.matches();
    }

    @Override
    public boolean isNipValid(String nip) {
        Matcher matcher = Pattern.compile("^\\d{10}$|^\\d{3}-[0-9]{3}-\\d{2}-\\d{2}$").matcher(nip);
        return matcher.matches();
    }

    @Override
    public boolean isPhoneValid(String phone) {
        Matcher matcher = Pattern.compile("^[0-9]+-?[0-9]+-?[0-9]+-?[0-9]+-?[0-9]*$").matcher(phone);
        return matcher.matches();
    }

    @Override
    public boolean isPostalCodeValid(String postalCode) {
        Matcher matcher = Pattern.compile("^\\d{2}-\\d{3}$").matcher(postalCode);
        return matcher.matches();
    }
}
