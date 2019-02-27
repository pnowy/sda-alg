package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

class Task3 {

    /**
     * Napisz program który obliczy silnie liczy N. Silnia to iloczyn liczb naturalnych <=N (mniejsze równe), silnie oznaczamy znakiem !, np: 3! = 3x2x1 = 6
     *  - napisz program iteracyjny
     *  - napisz program rekurencyjny
     *
     *  Spróbuj wykonać obliczenia dla większych liczb. Jakie będą czasy wykonania jednej i drugiej metody.
     */
    @Test
    void task() {
        System.out.println(factorial(5));
        System.out.println(factorial_recursive(5));
    }

    public static int factorial(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static int factorial_recursive(int n) {
        if(n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial_recursive(n - 1);
        }
    }

}
