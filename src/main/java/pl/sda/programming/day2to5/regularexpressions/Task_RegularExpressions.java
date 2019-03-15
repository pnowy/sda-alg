package pl.sda.programming.day2to5.regularexpressions;

/**
 * Pattern Class − A Pattern object is a compiled representation of a regular expression.
 *      The Pattern class provides no public constructors. To create a pattern, you must first invoke one of its
 *      public static compile() methods, which will then return a Pattern object. These methods accept a regular expression as the first argument.
 *
 * Matcher Class − A Matcher object is the engine that interprets the pattern and performs match operations against an input string.
 *      Like the Pattern class, Matcher defines no public constructors. You obtain a Matcher object by invoking the matcher() method on a Pattern object.
 *
 * PatternSyntaxException − A PatternSyntaxException object is an unchecked exception that indicates a syntax error in a regular expression pattern.
 *
 * https://www.freeformatter.com/java-regex-tester.html - free online regex tester
 *
 * Capturing groups are a way to treat multiple characters as a single unit. They are created by placing the characters
 * to be grouped inside a set of parentheses. For example, the regular expression (dog) creates a single group containing the letters "d", "o", and "g".
 *
 * https://www.tutorialspoint.com/java/java_regular_expressions.htm
 * https://regex101.com/
 *
 * Good tutorial in PL: https://www.samouczekprogramisty.pl/wyrazenia-regularne-w-jezyku-java/
 */
public interface Task_RegularExpressions {

    /**
     * Napisz metodę która za pomocą wyrażeń regularnych będzie walidować poprawność numeru PESEL (brak konieczności walidacji sumy kontrolnej, daty, etc.).
     */
    boolean isPeselValid(String pesel);

    /**
     * Napisz metodę która waliduje NIP. Może być podany w postaci z myślnikami (XXX-XXX-XX-XX) lub bez myślników (XXXXXXXXXX).
     */
    boolean isNipValid(String nip);

    /**
     * Napisz metodę która waliduje numer telefonu (zakładając, ze musi mieć minium 5 cyfr i maksymalnie 4 myślniki)
     */
    boolean isPhoneValid(String phone);

    /**
     * Napisz metodę która waliduje kod pocztowy (polski: XX-XXX)
     */
    boolean isPostalCodeValid(String postalCode);

}
