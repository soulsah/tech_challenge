package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ItemPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.PedidoDto;
import br.com.fiap.postech.soat.techchallenger1.application.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.application.ProdutoService;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public List<Pedido> findPedidosByClienteId(Long cliente_id) {
        return pedidoRepository.findPedidosByClienteId(cliente_id);
    }

    @Override
    public Pedido findPedidoById(Long id){
        return pedidoRepository.findPedidoById(id);
    }

    @Override
    public void novoPedido(PedidoDto pedido, List<ItemPedidoDto> itens){
        List<ItemPedido> listaItem = itens.stream().map(ItemPedido::new).toList();
        pedidoRepository.novoPedido(new Pedido(pedido), listaItem);
    }
}
