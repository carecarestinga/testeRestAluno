
package br.edu.ifrs.restinga.ds.carlossoares.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author carlos
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontrado  extends RuntimeException {

    public NaoEncontrado(String msg) {
        super(msg);
    }
    
    
    
}
