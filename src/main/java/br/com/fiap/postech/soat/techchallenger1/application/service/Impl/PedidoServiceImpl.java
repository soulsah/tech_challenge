package br.com.fiap.postech.soat.techchallenger1.application.service.Impl;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ItemPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoDto;
import br.com.fiap.postech.soat.techchallenger1.application.service.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.application.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() throws PedidoException{
        List<Pedido> pedidos = pedidoRepository.findAll();
        if(pedidos.isEmpty())
            throw new PedidoException("Nenhum pedido foi encontrado");
        return pedidoRepository.findAll();
    }

    @Override
    public List<Pedido> findPedidosByClienteId(Long cliente_id) throws PedidoException{
        List<Pedido> pedidos = pedidoRepository.findPedidosByClienteId(cliente_id);
        if(pedidos.isEmpty())
            throw new PedidoException("Nenhum pedido encontrado para este cliente");
        return pedidoRepository.findPedidosByClienteId(cliente_id);
    }

    @Override
    public Pedido findPedidoById(Long id) throws PedidoException{
        Pedido pedido = pedidoRepository.findPedidoById(id);
        if(pedido == null)
            throw new PedidoException("Pedido não encontrado");
        return pedidoRepository.findPedidoById(id);

    }

    @Override
    public void novoPedido(PedidoDto pedido, List<ItemPedidoDto> itens){
        List<ItemPedido> listaItem = itens.stream().map(ItemPedido::new).toList();
        pedidoRepository.novoPedido(new Pedido(pedido), listaItem);
    }
}
