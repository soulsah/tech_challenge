package br.com.fiap.postech.soat.techchallenger1.application.service.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.service.FilaService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.repository.FilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilaServiceImpl implements FilaService {
    @Autowired
    FilaRepository filaRepository;

    @Override
    public FilaPedido findFilaPedidoByPedidoId(Long id) {
        return filaRepository.findFilaPedidoByPedidoId(id);
    }

    @Override
    public void processarPedido(FilaPedido pedido) {
        filaRepository.processarPedido(pedido);
    }
}
