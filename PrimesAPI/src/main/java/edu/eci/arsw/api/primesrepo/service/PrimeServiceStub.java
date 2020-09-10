package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.persistence.PrimeException;
import edu.eci.arsw.api.primesrepo.persistence.PrimePersistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo 2/22/18.
 */
@Service
public class PrimeServiceStub implements PrimeService {
    @Autowired
    PrimePersistence pp;

    @Override
    public void addFoundPrime(FoundPrime foundPrime) throws PrimeException
    {
        pp.addFoundPrime(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes() throws PrimeException
    {
        return pp.getFoundPrimes();
    }

    @Override
    public FoundPrime getPrime( String prime ) throws PrimeException
    {
        return pp.getPrime(prime);
    }
}
