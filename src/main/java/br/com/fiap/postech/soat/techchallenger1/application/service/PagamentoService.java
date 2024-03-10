package br.com.fiap.postech.soat.techchallenger1.application.service;


import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PagamentoNaoEncontradoException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CheckoutDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.NotificacaoPagamentoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PagamentoResponseDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PagamentosDto;

public interface PagamentoService {

    PagamentoResponseDto checkout(CheckoutDto checkoutDto) throws CardNotFoundException, PedidoException;

    PagamentosDto getPagamentoById(Long id) throws PagamentoNaoEncontradoException;

    void updatePaymentStatus(NotificacaoPagamentoDto notificacaoPagamentoDto) throws PagamentoNaoEncontradoException;
}
