package edu.eci.arsw.api.primesrepo.persistence.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.persistence.PrimeException;
import edu.eci.arsw.api.primesrepo.persistence.PrimePersistence;

public class InMemoryPrimePersistence implements PrimePersistence {

    private final CopyOnWriteArrayList<FoundPrime> founders = new CopyOnWriteArrayList<FoundPrime>();

    @Override
    public void addFoundPrime(FoundPrime foundPrime) throws PrimeException {
        founders.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes() throws PrimeException {
        if(founders.isEmpty()){
            throw new PrimeException("Vacio");
        }
        return founders;
    }

    @Override
    public FoundPrime getPrime(String prime) throws PrimeException {
        FoundPrime fprime = null;
        for(FoundPrime f: founders){
            if(f.getPrime()==prime){
                fprime=f;
            }
        }
        if(fprime==null){
            throw new PrimeException("Prime not founded");
        }
        return fprime;
    }
    
}
