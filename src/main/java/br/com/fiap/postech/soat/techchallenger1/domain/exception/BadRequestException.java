package br.com.fiap.postech.soat.techchallenger1.domain.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

}
