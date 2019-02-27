package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

class Task11 {

    /**
     * Napisz program który podaną liczbę wejściową wyświetli w postaci binarnej (system dwójkowy)
     *
     * 111001 = 1⋅2^5+1⋅2^4+1⋅2^3+0⋅2^2+0⋅2^1+1⋅2^0 = 5710
     */
    @Test
    void task() {
        System.out.println(toBinary(1));
        System.out.println(toBinary(2));
        System.out.println(toBinary(3));
        System.out.println(toBinary(4));
        System.out.println(toBinary(5));
        System.out.println(toBinary(2147483647));
    }

    public static String toBinary(int number) {
        String result = "";
        for (int i = 0; i < 32; i++) {
            if(number % 2 == 1) {
                result = "1" + result;
            } else {
                result = "0" + result;
            }
            number = number/2;
        }

        return result;
    }

}
