package br.com.fiap.postech.soat.techchallenger1.application.exception;

public class PagamentoNaoEncontradoException extends Exception{

    public PagamentoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
