package edu.eci.arsw.primefinder;

import java.math.BigInteger;

import edu.eci.arsw.math.MathUtilities;

public class PrimeFinderThread extends Thread {

    private BigInteger a;
    private BigInteger b;
    private PrimesResultSet prs;
    public PrimeFinderThread(BigInteger left, BigInteger right, PrimesResultSet prs) {
        this.a = left;
        this.b = right;
        this.prs = prs;
    }

    @Override
    public void run() {
        MathUtilities mt = new MathUtilities();
        int itCount = 0;
        BigInteger i = a;
        while (i.compareTo(b) <= 0) {
            itCount++;
            if (mt.isPrime(i)) {
                prs.addPrime(i);
            }
            i = i.add(BigInteger.ONE);
        }
    }

}
