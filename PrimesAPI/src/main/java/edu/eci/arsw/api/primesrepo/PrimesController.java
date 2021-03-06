package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.persistence.PrimeException;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo 2/22/18.
 */
@RestController
@RequestMapping(value = "/primes")
public class PrimesController {

    @Autowired
    PrimeService primeService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getPrimes() {
        try {
            return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
        } catch (PrimeException ex) {
            Logger.getLogger(PrimesController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addFoundPrime(@RequestBody String body) {
        try {
            JsonNode rat = objectMapper.readTree(body);
            FoundPrime fprime = objectMapper.readValue(body, FoundPrime.class);
            primeService.addFoundPrime(fprime);
            return new ResponseEntity<>("HTTP 201", HttpStatus.ACCEPTED);
        } catch (PrimeException ex) {
            Logger.getLogger(PrimesController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.FORBIDDEN);
        } catch (JsonParseException e) {
            Logger.getLogger(PrimesController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        } catch (JsonMappingException e) {
            Logger.getLogger(PrimesController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            Logger.getLogger(PrimesController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{primenumber}", method = RequestMethod.GET)
    public ResponseEntity<?> getPrimeByNumber(@PathVariable String primenumber) {
        try {
            return new ResponseEntity<>(primeService.getPrime(primenumber), HttpStatus.ACCEPTED);
        } catch (PrimeException ex) {
            Logger.getLogger(PrimesController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

}
