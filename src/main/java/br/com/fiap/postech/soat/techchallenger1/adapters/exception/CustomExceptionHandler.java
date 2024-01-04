package br.com.fiap.postech.soat.techchallenger1.adapters.exception;

import br.com.fiap.postech.soat.techchallenger1.domain.exception.BadRequestException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CpfNaoEncontradoException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.PedidoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
    public class CustomExceptionHandler {
    @ExceptionHandler(CadastroClienteException.class)
    public ResponseEntity<Object> handleCadastroClienteException(CadastroClienteException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", status.value());
        body.put("error", e.getMessage());
        body.put("path", request.getRequestURI());

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> badRequest(BadRequestException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", status.value());
        body.put("error", e.getMessage());
        body.put("path", request.getRequestURI());
        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(CpfNaoEncontradoException.class)
    protected ResponseEntity<Object> badRequest(CpfNaoEncontradoException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", status.value());
        body.put("error", e.getMessage());
        body.put("path", request.getRequestURI());
        return new ResponseEntity<>(body, status);
    }
    
    @ExceptionHandler(PedidoException.class)
    protected  ResponseEntity<Object> badRequest(PedidoException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", status.value());
        body.put("error", e.getMessage());
        body.put("path", request.getRequestURI());
        return new ResponseEntity<>(body, status);
    }

}
