package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
public class ItemPedidoRepositoryDB {
    private DynamoDBMapper dynamoDBMapper;

    public ItemPedido save(ItemPedido itemPedido) {
        dynamoDBMapper.save(itemPedido);
        return itemPedido;
    }

    public List<ItemPedido> saveAll(List<ItemPedido> itemPedido) {
        itemPedido.forEach(this::save);
        return itemPedido;
    }
}
