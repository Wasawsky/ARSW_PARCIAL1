package edu.eci.arsw.api.primesrepo.persistence.impl;

import java.util.List;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.persistence.PrimeException;
import edu.eci.arsw.api.primesrepo.persistence.PrimePersistence;

public class InMemoryPrimePersistence implements PrimePersistence {

    @Override
    public void addFoundPrime(FoundPrime foundPrime) throws PrimeException {
        // TODO Auto-generated method stub

    }

    @Override
    public List<FoundPrime> getFoundPrimes() throws PrimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoundPrime getPrime(String prime) throws PrimeException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
