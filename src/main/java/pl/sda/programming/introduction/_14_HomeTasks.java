package pl.sda.programming.introduction;

final class _14_HomeTasks {

    public static void main(String[] args) {

        // 1. ZADANIE. Mamy tablicę numbers i 2 zmienne min i max:
        int[] numbers = new int[] { 10, 20, -3, 9, 15, -8 };
        int max = Integer.MIN_VALUE; // to jest: -2_147_483_648
        int min = Integer.MAX_VALUE; // to jest:  2_147_483_647
        // Za pomocą pętli for lub while znajdź i ustaw
        // w zmiennych min i max wartość najmniejszą i największą
        // występującą w tablicy numbers

        for (int number : numbers) {
            // ternary operator
            max = max < number ? number : max;
            min = min > number ? number : min;
        }
        System.out.println("min is: " + min + ", max is: " + max);

        // 1. ZADANIE.
        //    Dla liczb od 1 do 100 zsumuj wszystkie które dzielą się przez 3 i 7.
        //    Utwórz zmienną, która policzy ile razy wykonałeś sumowanie.
        //    Wypisz sumę oraz liczbę wykonanych operacji sumowania.
        int sum = 0;
        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 21 == 0) {
                sum += i;
                counter++;
            }
        }
        System.out.println("sum is: " + sum + ", counter: " + counter);

        /* 1. ZADANIE.
           Za pomocą dowolnej pętli wypisz na ekran gwiazdki:
           *
           * *
           * * *
           * * * *
           * * * * *
           * * * * * *

           Spróbuj to zrobić także w taki sposób:
           - zauważ, że liczba gwiazdek w każym wierszu jest nieparzysta
           - użyj tutaj StringBuilder
                   *
                 * * *
               * * * * *
             * * * * * * *
           * * * * * * * * *
        */
        StringBuilder builder = new StringBuilder();
        int stars = 10;
        for (int i = 0; i < stars; i++) {
            // append spaces
            for (int j = 0; j < ((stars - 1) * 2) - (2 * i); j++) {
                builder.append(' ');
            }
            // append stars
            for (int k = 0; k < (i * 2) + 1; k++) {
                builder.append('*').append(' ');
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }
}
