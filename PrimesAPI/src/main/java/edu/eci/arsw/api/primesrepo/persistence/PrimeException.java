package edu.eci.arsw.api.primesrepo.persistence;

public class PrimeException extends Exception{

    public PrimeException(String message) {
        super(message);
    }

    public PrimeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
