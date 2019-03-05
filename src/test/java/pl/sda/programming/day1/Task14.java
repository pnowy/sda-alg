package pl.sda.programming.day1;

import java.util.Scanner;

class Task14 {

    /**
     * Napisz kalkulator stringów. Kalkulator operuje tylko na małych literach. Operacje które musi obsługiwać kalkulator:
     *
     * add
     *
     *  "ala" + "mak" = "alamak"
     *
     * sub (a - b)
     *
     *  "ala" - "a" = "al"
     *  "ala" - "bba" = "al"
     *  "ala" - "xxx" = "ala"
     *  "ala" - "alaala" = ""
     *
     * sub_m (odwrotność sub, zamiast left - right to right - left)
     *
     *  "ala" -m "a" = ""
     *  "ala" -m "bba" = "bb"
     *  "ala" -m "xxx" = "xxx"
     *
     * uniq (unikalne znaki)
     *
     *  "ala" u = "al"
     *  "xxx" u = "x"
     *  "majtek" u = "majtek"
     *
     * inter (część wspólna)
     *
     *  "ala" u "aaa" = "aa"
     *  "kota" u "ole" = "o"
     *  "abcdefg" u "cdefghij" = "cdefg"
     *
     */
    public static void main(String[] args) {
        System.out.println("Some tests first");
        System.out.println("add");
        System.out.println(StringCalculator.add("asdf", "xxx"));
        System.out.println("sub");
        System.out.println(StringCalculator.sub("asdf", "xxx"));
        System.out.println(StringCalculator.sub("asdf", "aa"));
        System.out.println(StringCalculator.sub("asdf", "df"));
        System.out.println("add_m");
        System.out.println(StringCalculator.sub_m("ala", "a"));
        System.out.println(StringCalculator.sub_m("ala", "bba"));
        System.out.println(StringCalculator.sub_m("ala", "xxx"));
        System.out.println("uniq");
        System.out.println(StringCalculator.uniq("ala"));
        System.out.println(StringCalculator.uniq("xxx"));
        System.out.println(StringCalculator.uniq("majtek"));
        System.out.println("inter");
        System.out.println(StringCalculator.inter("ala", "aaa"));
        System.out.println(StringCalculator.inter("kota", "ole"));
        System.out.println(StringCalculator.inter("abcdefg", "cdefghij"));

        System.out.println("----- Now gimme some data and I'll compute the result -----");
        System.out.println("----- How to quit? q!               -----");
        System.out.println("----- How to use? ex. aaa + xxx     -----");
        System.out.println("----- How to use? ex. aaa - xxx     -----");
        System.out.println("----- How to use? ex. aaa u xxx     -----");
        System.out.println("----- How to use? ex. aaa u         -----");
        System.out.println("----- How to use? ex. aaa sub_m abc -----");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = "";
            String input = scanner.nextLine();
            String[] split = input.split(" ");

            if (input.equals("q!")) {
                // ok
            } else if (split.length == 2 && split[1].equals("u")) {
                // ok
            } else if (split.length == 3) {
                // ok
            } else {
                System.out.println("wrong input");
                continue;
            }

            if (input.equals("q!")) {
                break;
            } else if (split[1].equals("+")) {
                result = StringCalculator.add(split[0], split[2]);
            } else if (split[1].equals("-")) {
                result = StringCalculator.sub(split[0], split[2]);
            } else if (split[1].equals("sub_m")) {
                result = StringCalculator.sub_m(split[0], split[2]);
            } else if (split[1].equals("u") && split.length == 2) {
                result = StringCalculator.uniq(split[0]);
            } else if (split[1].equals("u") && split.length == 3) {
                result = StringCalculator.inter(split[0], split[2]);
            } else {
                System.out.println("wrong input");
            }

            System.out.println(result);
        }
    }


    static class StringCalculator {
        public static String add(String left, String right) {
            return left + right;
        }

        public static String sub(String left, String right) {
            char[] chars = right.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                String character = String.valueOf(chars[i]);
                if (left.contains(character)) {
                    left = left.replaceFirst(character, "");
                }
            }
            return left;
        }

        public static String sub_m(String left, String right) {
            return sub(right, left);
        }

        public static String uniq(String text) {
            String result = "";
            while (text.length() != 0) {
                String character = String.valueOf(text.charAt(0));
                result += character;
                text = text.replaceAll(character, "");
            }
            return result;
        }

        public static String inter(String left, String right) {
            String result = "";
            while (left.length() != 0) {
                String character = String.valueOf(left.charAt(0));
                if (right.contains(character)) {
                    result += character;
                    left = left.replaceFirst(character, "");
                    right = right.replaceFirst(character, "");
                } else {
                    left = left.replaceFirst(character, "");
                }
            }
            return result;
        }

    }

}
