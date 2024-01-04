package br.com.fiap.postech.soat.techchallenger1.application;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ItemPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.PedidoDto;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> findAll() throws PedidoException;
    List<Pedido> findPedidosByClienteId(Long cliente_id) throws PedidoException;

    Pedido findPedidoById(Long id) throws PedidoException;
    void novoPedido(PedidoDto pedido, List<ItemPedidoDto> itens);
}
