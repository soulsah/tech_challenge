package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ItemPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.application.ItemPedidoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Autowired
    ItemPedidoRepository repository;

    @Override
    public void save(ItemPedidoDto itemPedidoDto) {
        repository.addItem(new ItemPedido(itemPedidoDto));
    }
}
