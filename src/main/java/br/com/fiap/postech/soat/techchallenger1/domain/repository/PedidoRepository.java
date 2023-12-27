package br.com.fiap.postech.soat.techchallenger1.domain.repository;

import br.com.fiap.postech.soat.techchallenger1.adapters.repository.PedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository {
    @Autowired
    PedidoRepositoryDB pedidoRepository;
    public List<Pedido> findAll(){ return pedidoRepository.findAll(); }
    public List<Pedido> findPedidosByClienteId(Long cliente_id){ return pedidoRepository.findPedidosByClienteId(cliente_id);}
}
