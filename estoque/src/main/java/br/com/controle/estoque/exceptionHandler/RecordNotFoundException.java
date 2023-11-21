package br.com.controle.estoque.exceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String message) {
        super(message);
    }
}
