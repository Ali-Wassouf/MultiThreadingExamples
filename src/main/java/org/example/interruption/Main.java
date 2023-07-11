package org.example.interruption;

import java.math.BigInteger;

public class Main {

    public static void main(String... args){
        var longComputation = new LongComputation(BigInteger.valueOf(3000), BigInteger.valueOf(4000));
        var thread = new Thread(longComputation);
        thread.start();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
}
