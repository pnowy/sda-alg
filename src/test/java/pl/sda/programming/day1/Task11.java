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

    }

    int fromBinary(String binary) {
        int result = 0;
        String reversed = new StringBuilder(binary).reverse().toString();
        for (int i = 0; i < reversed.length(); i++) {
            double val = Math.pow(2, i) * Character.getNumericValue(reversed.charAt(i));
            result += val;
        }
        return result;
    }

}
