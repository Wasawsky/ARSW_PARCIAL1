package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo 2/22/18.
 */
@RestController
public class PrimesController {

    PrimeService primeService;

    @RequestMapping(value = "/primes", method = GET)
    public List<FoundPrime> getPrimes() {
        return primeService.getFoundPrimes();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getPrimesServ() {
        try {
            // obtener datos que se enviarán a través del API
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (XXException ex) {
            Logger.getLogger(XXController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }

    // TODO implement additional methods provided by PrimeService

}
