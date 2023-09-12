package br.com.horizon.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ResourceNotAcceptableException extends RuntimeException {

    public ResourceNotAcceptableException(String message) {
        super(message);
    }
}
