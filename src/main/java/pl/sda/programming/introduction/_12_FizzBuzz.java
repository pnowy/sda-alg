package pl.sda.programming.introduction;

final class _12_FizzBuzz {

    public static void main(String[] args) {

        // write program that prints:
        // - numbers from 1 to 100
        // - but for multiples of 3 prints "Fizz"
        // - but for multiples of 5 prints "Buzz"
        // - but for multiples of 3 and 5 prints "FizzBuzz"

        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
