package br.com.fiap.postech.soat.techchallenger1.application.repository;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.FilaPedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.ItemPedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.PedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository {
    @Autowired
    PedidoRepositoryDB pedidoRepository;

    @Autowired
    ItemPedidoRepositoryDB itemPedidoRepository;

    @Autowired
    FilaPedidoRepositoryDB filaPedidoRepository;

    public List<Pedido> findAll(){ return pedidoRepository.findAll(); }
    public List<Pedido> findPedidosByClienteId(Long cliente_id){ return pedidoRepository.findPedidosByClienteId(cliente_id);}

    public Pedido findPedidoById(Long id) { return pedidoRepository.findPedidoById(id); }

    public void novoPedido(Pedido pedido, List<ItemPedido> itens){
        Pedido novoPedido = new Pedido();
        novoPedido.setClienteId(pedido.getClienteId());
        novoPedido.setStatus(pedido.getStatus());
        pedidoRepository.save(novoPedido);

        FilaPedido filaPedido = new FilaPedido();
        filaPedido.setPedidoId(novoPedido.getId());
        filaPedido.setClienteId(novoPedido.getClienteId());
        filaPedido.setStatusPedido(novoPedido.getStatus());
        filaPedidoRepository.save(filaPedido);

        List<ItemPedido> itensPedido = itens.stream()
                .map(item -> {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setPedidoId(novoPedido.getId());
                    itemPedido.setProduto(item.getProduto());
                    itemPedido.setQuantidade(item.getQuantidade());
                    return itemPedido;
                }).toList();
        itemPedidoRepository.saveAll(itensPedido);
    }

    public double getValorTotal(Long pedidoId) {
        return pedidoRepository.getValorTotal(pedidoId);
    }
}
