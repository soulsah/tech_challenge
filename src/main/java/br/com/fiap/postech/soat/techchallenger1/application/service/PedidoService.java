package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ItemPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoDto;
<<<<<<< HEAD
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
=======
import br.com.fiap.postech.soat.techchallenger1.domain.exception.PedidoException;
>>>>>>> e77518c0e3dfbb4069ea381664d56ab75376a827
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> findAll() throws PedidoException;
    List<Pedido> findPedidosByClienteId(Long cliente_id) throws PedidoException;

    Pedido findPedidoById(Long id) throws PedidoException;
    void novoPedido(PedidoDto pedido, List<ItemPedidoDto> itens);
}
