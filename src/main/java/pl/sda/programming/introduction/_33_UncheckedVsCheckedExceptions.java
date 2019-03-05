package pl.sda.programming.introduction;

final class _33_UncheckedVsCheckedExceptions {
    public static void main(String[] args) {
        // unchecked - RuntimeExceptions
        int result = Unchecked.factorial(10);
        System.out.println(result);

        // checked - Exception
        try {
            result = Checked.factorial(0);
            System.out.println(result);
        } catch (InvalidFactorialArgumentException ex) {
            ex.printStackTrace();
        }
    }
}

class Unchecked {
    static int factorial(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("argument n must be greater then 0");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i; // result = result * i
        }
        return result;
    }
}

class Checked {
    static int factorial(int n) throws InvalidFactorialArgumentException {
        if (n < 1) {
            throw new InvalidFactorialArgumentException("argument n must be greater then 0");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i; // result = result * i
        }
        return result;
    }
}

class InvalidFactorialArgumentException extends Exception {
    InvalidFactorialArgumentException(String message) {
        super(message);
    }
}