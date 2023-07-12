package org.example.joining;

import org.example.interruption.LongComputation;

import java.math.BigInteger;
import java.util.Arrays;

public class ComplexCalculation {

    public static void main(String... args) {
        System.out.println(calculateResult(BigInteger.valueOf(33L), BigInteger.valueOf(33L)
                , BigInteger.valueOf(93L), BigInteger.valueOf(33)));
    }

    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;

        var thread1 = new LongComputation(base1, power1);
        var thread2 = new LongComputation(base2, power2);

        var list = Arrays.asList(thread1, thread2);
        for (Thread th : list) {
            th.start();
        }

        for (Thread th : list) {
            try {
                th.join(9000);
                th.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        result = thread1.getResult().add(thread2.getResult());
        return result;
    }
}
