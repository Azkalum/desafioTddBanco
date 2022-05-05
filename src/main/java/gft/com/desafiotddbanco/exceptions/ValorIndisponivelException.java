package gft.com.desafiotddbanco.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValorIndisponivelException extends Exception {

    public ValorIndisponivelException(String message) {
        super(message);
    }

}
