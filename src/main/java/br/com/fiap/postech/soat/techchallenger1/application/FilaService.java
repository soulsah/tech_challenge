package br.com.fiap.postech.soat.techchallenger1.application;

import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;

public interface FilaService {
    FilaPedido findFilaPedidoByPedidoId(Long id);
    void processarPedido(FilaPedido pedido);
}
