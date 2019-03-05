package pl.sda.programming.introduction;

final class _03_Operators {

    public static void main(String[] args) {
        // arithmetical operators
        // +, -, *, /, %
        byte plus = 122 + 5;
        int plus2 = plus + 40;
        System.out.println("plus2 is = " + plus2);

        int multiply = plus2 * 2;
        int division = plus2 / 100;
        System.out.println("Multiply is " + multiply);
        System.out.println("Division is " + division);

        // what if I divide by zero?
        // int divideByZero = plus2 / 0; -> it will raise exception in runtime
        // System.out.println("it will be not visible");

        // what if I divide double by zero?
        double d1 = 2.000 / 0;
        // it's infinity
        System.out.println(d1);

        // modulo
        System.out.println(15 % 7);

        // from int to double
        System.out.println(15 / 2.0);

        // shortcuts
        int x = 4;
        x = x + 4;
        x += 4; // the same to above example
        System.out.println("x is " + x);

        // increment and decrement
        x = 0;
        x += 1;
        x++; // it adds 1 to x
        ++x; // it adds 1 to x
        System.out.println("x is " + x);

        System.out.println(x++);
        System.out.println(++x);

        x = 0;
        --x;
        x--;
        System.out.println(x--);

        // operations
        double d2 = (((x - plus) / 100) * 4.5) / 75;
        System.out.println("result is " + d2);


        // relational and logical operators
        boolean equal = (5 == 5);
        System.out.println("is equal " + equal);

        boolean notEqual = (5 != 5);
        System.out.println("is not equal " + notEqual);

        boolean greaterThen = (5 > 5);
        System.out.println("greater then is " + greaterThen);

        boolean greaterThenOrEqual = (5 >= 5);
        System.out.println("greater then is " + greaterThenOrEqual);

        boolean lowerThen = (5 < 5);
        System.out.println("lower then is " + lowerThen);

        boolean lowerThenEqual = (5 <= 5);
        System.out.println("lower or equal is " + lowerThenEqual);

        // logical: && (and), || (or)
        boolean isOk = (5 == 5) && (5 < 10);

        // and
        // true && true   = true
        // true && false  = false
        // false && true  = false
        // false && false = false

        // or
        // true || true   = true
        // true || false  = true
        // false || true  = true
        // false || false = false

        int y = 10;
        int t = 20;
        boolean isTrue = ((y < t) || (t == y)) && (y + 15 < 30);


        // binary operators
        // & - binary and
        // | - binary or
        // ^ - binary xor
        // ~ - binary negation
        // <<, >> - shift operators

        int b1 = 6 & 2;
        System.out.println("6 & 2 is " + b1);
        System.out.println("6 | 2 is " + (6 | 2));
        /*
            & - operation
            x1 = 0 1 1 0   = 6
            x2 = 0 1 1 0   = 2
               = 0 0 1 0   = 2

            | - operation
            x1 = 0 1 1 0   = 6
            x2 = 0 0 1 0   = 2
               = 0 1 1 0   = 6
         */

        int b2 = 1 << 1;
        System.out.println("shift result is " + b2);
    }
}
