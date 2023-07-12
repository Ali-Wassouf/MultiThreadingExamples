package org.example.interruption;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class LongComputationTest {

    @Test
    void run() {

        var l = new LongComputation(BigInteger.valueOf(3L), BigInteger.valueOf(3L));
        l.run();
    }
}