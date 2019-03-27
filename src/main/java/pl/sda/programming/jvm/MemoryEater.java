package pl.sda.programming.jvm;

import java.util.ArrayList;

public class MemoryEater {
    public static void main(String[] args) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        while (true) {
            byte b[] = new byte[1048576];
            arrayList.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.println("free memory: " + CheckJavaMemory.humanReadableByteCount(rt.freeMemory()));
        }
    }
}
