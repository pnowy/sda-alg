package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

class Task9 {

    /**
     * Napisz program który sprawdzi czy słowo jest palindromem
     */
    @Test
    void task() {
        System.out.println("isPalindrome(\"" + "test" + "\")=" + isPalindrome("test"));
        System.out.println("isPalindrome(\"" + "cat" + "\")=" + isPalindrome("cat"));
        System.out.println("isPalindrome(\"" + "kajak" + "\")=" + isPalindrome("kajak"));
        System.out.println("isPalindrome(\"" + "no palindrome" + "\")=" + isPalindrome("no palindrome"));
        System.out.println("isPalindrome(\"" + "xXXx" + "\")=" + isPalindrome("xXXx"));

        System.out.println("isPalindrome2(\"" + "test" + "\")=" + isPalindrome2("test"));
        System.out.println("isPalindrome2(\"" + "cat" + "\")=" + isPalindrome2("cat"));
        System.out.println("isPalindrome2(\"" + "kajak" + "\")=" + isPalindrome2("kajak"));
        System.out.println("isPalindrome2(\"" + "no palindrome" + "\")=" + isPalindrome2("no palindrome"));
        System.out.println("isPalindrome2(\"" + "xXXx" + "\")=" + isPalindrome2("xXXx"));

        System.out.println("isPalindrome3(\"" + "test" + "\")=" + isPalindrome3("test"));
        System.out.println("isPalindrome3(\"" + "cat" + "\")=" + isPalindrome3("cat"));
        System.out.println("isPalindrome3(\"" + "kajak" + "\")=" + isPalindrome3("kajak"));
        System.out.println("isPalindrome3(\"" + "no palindrome" + "\")=" + isPalindrome3("no palindrome"));
        System.out.println("isPalindrome3(\"" + "xXXx" + "\")=" + isPalindrome3("xXXx"));
    }

    // using our previous function to reverse String
    private static boolean isPalindrome(String text) {
        if(text.equals(Task4.reverse(text))) {
            return true;
        } else {
            return false;
        }
        // this function could also be simplified to just one line:
        // return text.equals(Exercise4_ReverseString.reverse(text));
    }

    // without reversing strings
    private static boolean isPalindrome2(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    // without reversing strings using while
    private static boolean isPalindrome3(String text) {
        char[] chars = text.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if(chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
