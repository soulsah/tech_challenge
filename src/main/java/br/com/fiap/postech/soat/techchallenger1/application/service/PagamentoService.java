package br.com.fiap.postech.soat.techchallenger1.application.service;


import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CheckoutDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PagamentoResponseDto;

public interface PagamentoService {

    PagamentoResponseDto checkout(CheckoutDto checkoutDto) throws CardNotFoundException, PedidoException;
}
