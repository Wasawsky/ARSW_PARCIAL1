package edu.eci.arsw.api.primesrepo.persistence;

import java.util.List;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

public interface PrimePersistence {
    public void addFoundPrime(FoundPrime foundPrime) throws PrimeException;
    public List<FoundPrime> getFoundPrimes() throws PrimeException;
    public FoundPrime getPrime(String prime) throws PrimeException;
}
