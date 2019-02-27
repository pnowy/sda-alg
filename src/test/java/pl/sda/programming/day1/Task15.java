package pl.sda.programming.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

class Task15 {

    /**
     * Napisz program który sprawdzi czy dwa podane wyrazy są anagramami.
     * <p>
     * - Zmodyfikuj program tak by słowa do sprawdzenia wczytał z pliku. Nadal będą to tylko 2 słowa oddzielone znakiem nowej lini
     * - Zmodyfikuj program tak by znalazł wszystkie anagramy dla słów z pliku oddzielonych znakiem nowej lini.
     * <p>
     * Do ostatecznego przetestowania programu użyj listy słów: http://codekata.com/data/wordlist.txt (do znalezienia jest 20683 anagramów)
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(areAnagrams("asdf", "asdf"));
        System.out.println(areAnagrams("cat", "tac"));
        System.out.println(areAnagrams("dog", "god"));
        System.out.println(areAnagrams("whatever", "god"));
        System.out.println(areAnagrams("here", "we"));

//        File file = new File("words.txt");
//        Scanner scanner = new Scanner(file);
//        String wordA = scanner.nextLine();
//        String wordB = scanner.nextLine();
//        System.out.println(areAnagrams(wordA, wordB));

        File file = new File("wordlist.txt");
        Scanner scanner = new Scanner(file);
        List<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) { // when reading from file we can use .hasNextLine() without blocking
            words.add(scanner.nextLine());
        }
        for (int i = 0; i < words.size(); i++) {
            String wordA = words.get(i);
            List<String> anagrams = new ArrayList<>();
            for (int j = i + 1; j < words.size(); j++) {
                String wordB = words.get(j);
                if (areAnagrams(wordA, wordB)) {
                    anagrams.add(wordB);
                }
            }
            if (anagrams.size() > 0) {
                System.out.print(wordA + " ");
                for (String word : anagrams) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }

    }

    // faster verion of anagrams
//    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("wordlist.txt");
//        Scanner scanner = new Scanner(file);
//        List<String> words = new ArrayList<>();
//        while (scanner.hasNextLine()) { // when reading from file we can use .hasNextLine() without blocking
//            words.add(scanner.nextLine());
//        }
//
//        Map<String, List<String>> dic = words
//                .stream()
//                .collect(Collectors.groupingBy(x -> sortString(x)));
//
//        dic
//                .keySet()
//                .stream()
//                .filter(x -> dic.get(x).size() > 1)
//                //.filter(x -> dic.get(x).size() > 5) // uncomment this to print only long anagrams
//                .map(x -> String.join(" ", dic.get(x)))
//                .forEach(x -> System.out.println(x));
//    }

    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private static boolean areAnagrams(String wordA, String wordB) {
        String sub1 = Task14.StringCalculator.sub(wordA, wordB);
        String sub2 = Task14.StringCalculator.sub(wordB, wordA);
        return sub1.equals("") && sub2.equals("");
    }
}
