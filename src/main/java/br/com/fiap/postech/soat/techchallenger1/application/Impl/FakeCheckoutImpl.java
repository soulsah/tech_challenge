package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.FakeCheckoutService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import br.com.fiap.postech.soat.techchallenger1.domain.model.FakeCheckout;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;

import java.util.List;

public class FakeCheckoutImpl implements FakeCheckoutService {
    @Override
    public boolean checkout(Cliente cliente, Pedido pedido, List<Produto> produtos) {
        return false;
    }
}
