package org.example.interruption;

import java.math.BigInteger;

public class LongComputation implements Runnable {

    private BigInteger base;
    private BigInteger power;

    public LongComputation(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    private BigInteger power(BigInteger base, BigInteger pow) {
        var result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(pow) != 0; i.add(BigInteger.ONE)) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("The calculation is interrupted");
                return BigInteger.ZERO;
            }
            result = result.multiply(base);
        }
        return result;
    }

    @Override
    public void run() {
        System.out.println(base + "^" + power + "=" + power(base, power));
    }
}
