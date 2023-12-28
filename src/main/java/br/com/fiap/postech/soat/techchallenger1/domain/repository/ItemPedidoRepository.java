package br.com.fiap.postech.soat.techchallenger1.domain.repository;

import br.com.fiap.postech.soat.techchallenger1.adapters.repository.ItemPedidoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemPedidoRepository {

    @Autowired
    ItemPedidoRepositoryDB repositoryDB;

    public void addItem(ItemPedido item) { repositoryDB.save(item); }
}
