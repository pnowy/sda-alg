package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

import java.io.File;

class Task17 {

    /**
     * Napisz program który sprawdzi czy w katalogu są pliki z rozszerzeniem txt i wypisze pliki z takim rozszrzeniem. Program musi brać
     * pod uwagę zarówno małe jak i wielkie litery.
     */
    @Test
    void task() {
        File file = new File("/home/students/");
        String[] list = file.list((dir, name) -> name.toLowerCase().endsWith(".txt"));
        assert list != null;
        for(String f:list){
            System.out.println(f);
        }
    }
}
