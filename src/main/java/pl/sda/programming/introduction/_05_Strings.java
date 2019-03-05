package pl.sda.programming.introduction;

final class _05_Strings {

    public static void main(String[] args) {

        // strings are immutable,
        // once created cannot be changed

        String str1 = "abc";
        str1 = "edc";

        // how to create strings
        str1 = new String(); // it's empty = ""
        str1 = "";
        str1 = new String(new char[] {'a', 'b'});

        // how to concatenate strings
        String str2 = "yupi";
        String str3 = "dupi";
        str1 = str2 + " " + str3;
        System.out.println(str1);

        // how to concatenate with other types
        String str4 = "with int: " + 5;
        String str5 = "with double: " + 5.99;
        String str6 = "with boolean: " + true;
        System.out.println(str4 + ", " + str5 + "," + str6);

        // how to compare strings
        String str7 = "test";
        String str8 = new String("TesT");
        System.out.println(str7 == str8); // forgot about this, don't do that
        System.out.println("compare 1: " + (str7.equals(str8)));

        System.out.println("compare ignore case: " + (str7.equalsIgnoreCase(str8)));

        // what is length?
        System.out.println("string length: " + ("ala ma kota".length()));

        // how to get substring
        String sentence = "ala ma kota";
        String subword  = sentence.substring(4, 6);
        System.out.println("subword is: " + subword);

        // how to replace characters
        String replaced = sentence.replace('m', 'n');
        System.out.println("replaced is: " + replaced);

        // how to remove spaces from start and end
        String sentence2 = "   ala miała kota    ";
        String trimmed = sentence2.trim();
        System.out.println("trimmed is '" + trimmed + "'");

        // how to check if string contains word
        System.out.println("sentence contains \"kot\": " + (sentence.contains("kot")));

        // how to change string to uppercase
        String upper = "ala".toUpperCase();
        System.out.println("Uppercase: " + upper);
        // how to change string to lowercase
        System.out.println("Lowercase: " + upper.toLowerCase());

        // how to check if string starts with or ends with word
        boolean startsWith = "ala ma kota".startsWith("ala");
        boolean endsWith = "ale nie ma kota miau".endsWith("miau");
        System.out.println("starts with = " + startsWith + ", ends with = " + endsWith);

        System.out.println(sentence.replaceAll("al.", ""));
    }
}
