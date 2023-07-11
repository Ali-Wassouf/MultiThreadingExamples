package org.example.vaultcracking;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String... args) {
        var vault = new Vault(new Random(999).nextInt());
        var arrayList = new ArrayList<Thread>();
        arrayList.add(new AscendingHacker(vault));
        arrayList.add(new DescendingHacker(vault));
        arrayList.add(new Police());
        for(var thread: arrayList){
            thread.start();
        }
    }
}
