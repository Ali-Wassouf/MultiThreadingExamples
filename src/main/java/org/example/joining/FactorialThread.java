package org.example.joining;

import java.math.BigInteger;

public class FactorialThread extends Thread {
    private BigInteger result = BigInteger.ZERO;
    private long inputNumber;
    private boolean isFinished = false;

    public FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
        this.isFinished = false;
    }

    @Override
    public void run() {
        this.result = factorialCalc(inputNumber);
        this.isFinished = true;
    }

    private BigInteger factorialCalc(long inputNumber) {
        var temp = BigInteger.ONE;
        for (long i = inputNumber; i > 0; i--) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread " + this.getId() + " is interrupted");
                return BigInteger.ZERO;
            }
            temp = temp.multiply(BigInteger.valueOf(i));
        }
        return temp;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
