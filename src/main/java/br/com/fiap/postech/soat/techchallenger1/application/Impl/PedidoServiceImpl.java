package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Override
    public boolean criarPedido(Pedido pedido) { return false; }
}
