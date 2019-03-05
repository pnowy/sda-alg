package pl.sda.programming.introduction;

final class _08_IfStatements {

    public static void main(String[] args) {

        // variable visibility
        int x = 0;
        { // inner code block
            x = 1;
            int n = 2;
            n += x;
            System.out.println("n is " + n);

            {
                {
                    {
                        // inner code blocks
                        // don't do that
                        int u = x;
                    }
                }
            }
        }

        // x = n;

        // if statement
        if (true) {
            System.out.println("is true");
        }

        String sentence = "ala miała chomika";
        if (sentence.startsWith("ala")) {
            System.out.println("sentence starts with 'ala'");
        }

        int j = 10;
        int k = 100;
        if (j > 9 && k >= 100) {
            System.out.println("expression is true");
        }

        // if/else
        if (j < 10) {
            System.out.println("it's true");
        } else {
            System.out.println("'j' is equal or greater then 10");
        }

        if (j >= 10)
            System.out.println("'j' is equal or greater then 10");
            // System.out.println();
        else
            System.out.println("it's not true");

        // if/else if/else
        if (j > 10) {
            System.out.println("'j' is greater then 10");
        } else if (j < 10) {
            System.out.println("'j' is lower then 10");
        } else {
            System.out.println("'j' is 10");
        }

        // if/else if/else
        if (j == 10) {
            int u = k + j;
            System.out.println("'us' is " + u);
        } else if (j % 2 == 0) {
            System.out.println("'j' % 2 is 0");
        }

        int y;
        if ((j % 3) == 0) {
            y = 2;
        } else {
            y = 0;
        }
        j = y;
    }
}
