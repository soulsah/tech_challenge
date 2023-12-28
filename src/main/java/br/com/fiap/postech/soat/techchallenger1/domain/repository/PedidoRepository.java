package br.com.fiap.postech.soat.techchallenger1.domain.repository;

import br.com.fiap.postech.soat.techchallenger1.adapters.repository.ItemPedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.adapters.repository.PedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository {
    @Autowired
    PedidoRepositoryDB pedidoRepository;

    @Autowired
    ItemPedidoRepositoryDB itemPedidoRepository;

    public List<Pedido> findAll(){ return pedidoRepository.findAll(); }
    public List<Pedido> findPedidosByClienteId(Long cliente_id){ return pedidoRepository.findPedidosByClienteId(cliente_id);}

    public Pedido findPedidoById(Long id) { return pedidoRepository.findPedidoById(id); }

    public void novoPedido(Pedido pedido, List<ItemPedido> itens){
        Pedido novoPedido = new Pedido();
        novoPedido.setClienteId(pedido.getClienteId());
        novoPedido.setStatus(pedido.getStatus());
        pedidoRepository.save(novoPedido);

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
}
