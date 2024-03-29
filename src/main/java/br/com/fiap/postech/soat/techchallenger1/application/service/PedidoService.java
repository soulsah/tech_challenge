package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ItemPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoDto;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;


import java.util.List;

public interface PedidoService {
    List<Pedido> findAll() throws PedidoException;
    List<Pedido> findPedidosByClienteId(Long cliente_id) throws PedidoException;

    double getValorTotal(Long pedidoId);

    Pedido findPedidoById(Long id) throws PedidoException;
    void novoPedido(PedidoDto pedido, List<ItemPedidoDto> itens);
}
