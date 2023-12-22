package br.com.fiap.postech.soat.techchallenger1.application;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;

import java.util.List;

public interface PedidoService {
    public List<Pedido> findAll();
    public List<Pedido> findPedidoByCliente(Long cliente_id);
}
