package pl.sda.programming.introduction;

final class _07_StringFormat {
    public static void main(String[] args) {
        // template for displaying strings with many
        // variables

        System.out.printf("Hello %s! Your best number is: %d \n", "Ala", 7);

        // float number
        System.out.printf("float number: %,.2f", 333333.33333);

        // https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
    }
}
