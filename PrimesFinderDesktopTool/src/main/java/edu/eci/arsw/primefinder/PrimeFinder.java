package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder{
        
	
	
        
	public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs){
            
                BigInteger a=_a;
                BigInteger b=_b;

                BigInteger lenght = new BigInteger("4");
                BigInteger cero = new BigInteger("0");

                BigInteger spaceWork = (b.subtract(a)).divide(lenght);

                System.out.println(spaceWork);
                //Paralelizar

                List<PrimeFinderThread> trs = new ArrayList<PrimeFinderThread>();

                if(spaceWork.compareTo(cero)==0){

                }

                for(int i=1; i<=4; i++){
                    BigInteger next = new BigInteger("0");
                    BigInteger left = spaceWork.multiply(next);
                    BigInteger right = left.add(spaceWork);
                    //trs.add(new PrimeFinderThread(left, right)):
                }

                /*
                MathUtilities mt=new MathUtilities();
                int itCount=0;
                BigInteger i=a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        prs.addPrime(i);
                    }
                    i=i.add(BigInteger.ONE);
                    System.out.println(itCount);
                }
                */
    }
    
    public static void finder() {
        
    }
	
	
	
	
	
}
