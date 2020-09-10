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
                BigInteger one = new BigInteger("1");

                BigInteger spaceWork = (b.subtract(a)).divide(lenght);

                System.out.println(spaceWork);

                List<PrimeFinderThread> trs = new ArrayList<PrimeFinderThread>();
                BigInteger next = a;
                for(int i=1; i<=4; i++){
                    BigInteger left = next;
                    BigInteger right = left.add(spaceWork);
                    next = right.add(one);
                    System.out.println("l: "+left+" r: "+ right + " next:" + next);
                    trs.add(new PrimeFinderThread(left, right,prs));
                }

                for(PrimeFinderThread pt : trs ){
                    pt.start();
                }

                for(PrimeFinderThread pt : trs ){
                    try {
                        pt.join();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }
    }
	
}
