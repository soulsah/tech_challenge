package br.com.fiap.postech.soat.techchallenger1.application;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import br.com.fiap.postech.soat.techchallenger1.domain.model.FakeCheckout;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;

import java.util.List;

public interface FakeCheckoutService {
    public boolean checkout(Pedido pedido);
}
