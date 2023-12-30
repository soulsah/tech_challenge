package br.com.fiap.postech.soat.techchallenger1.domain.repository;

import br.com.fiap.postech.soat.techchallenger1.adapters.repository.FilaPedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.adapters.repository.PedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FilaRepository {
    @Autowired
    FilaPedidoRepositoryDB filaPedidoRepository;

    @Autowired
    PedidoRepositoryDB pedidoRepository;

    public FilaPedido findFilaPedidoByPedidoId(Long id){
        return filaPedidoRepository.findFilaPedidoByPedidoId(id);
    }

    public void processarPedido(FilaPedido pedido){
        FilaPedido novoStatus = new FilaPedido();
        novoStatus.setPedidoId(pedido.getPedidoId());
        novoStatus.setClienteId(pedido.getClienteId());
        novoStatus.setStatusPedido(pedido.getStatusPedido().next());
        filaPedidoRepository.save(novoStatus);

        Pedido novoStatusPedido = new Pedido();
        novoStatusPedido.setId(pedido.getPedidoId());
        novoStatusPedido.setClienteId(pedido.getClienteId());
        novoStatusPedido.setStatus(novoStatus.getStatusPedido());
        pedidoRepository.save(novoStatusPedido);
    }
}
