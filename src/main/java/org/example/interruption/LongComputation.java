package org.example.interruption;

import java.math.BigInteger;

public class LongComputation extends Thread {

    private BigInteger base;
    private BigInteger power;

    private BigInteger result;

    private boolean idFinished = false;

    public LongComputation(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    private BigInteger power(BigInteger base, BigInteger pow) {
        var result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(pow) != 0; i = i.add(BigInteger.ONE)) {
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
        this.result = power(base, power);
        System.out.println(base + "^" + power + "=" + result);
        idFinished = true;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isIdFinished() {
        return idFinished;
    }
}
