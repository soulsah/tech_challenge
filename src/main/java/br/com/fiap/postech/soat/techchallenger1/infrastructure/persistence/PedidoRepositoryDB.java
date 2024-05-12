package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Repository
@AllArgsConstructor
public class PedidoRepositoryDB  {

    private DynamoDBMapper dynamoDBMapper;

    public double getValorTotal(@Param("pedidoId") Long pedidoId){
        List<ItemPedido> itensPedido = dynamoDBMapper.scan(ItemPedido.class, new DynamoDBScanExpression().withFilterExpression("pedidoId = :v1").withExpressionAttributeValues(Collections.singletonMap(":v1", new AttributeValue().withN(String.valueOf(pedidoId)))));
        double total = 0;
        for (ItemPedido item : itensPedido) {
            var produto = dynamoDBMapper.load(Produto.class,item.getProduto());
            total += produto.getPreco().doubleValue() * item.getQuantidade();
        }
        return total;
    }

    public List<Pedido> findAll(){
        List<Pedido> pedidos = dynamoDBMapper.scan(Pedido.class, new DynamoDBScanExpression().withFilterExpression("status <> :v1").withExpressionAttributeValues(Collections.singletonMap(":v1", new AttributeValue().withN("3"))));
        return pedidos;
    }

    public List<Pedido> findPedidosByClienteId(Long id)
    {
        List<Pedido> pedidos = dynamoDBMapper.scan(Pedido.class, new DynamoDBScanExpression().withFilterExpression("idCliente = :v1").withExpressionAttributeValues(Collections.singletonMap(":v1", new AttributeValue().withN(String.valueOf(id)))));
        return pedidos;
    }

    public Pedido findPedidoById(Long id){
        return dynamoDBMapper.load(Pedido.class, id);
    }

    public Pedido save(Pedido pedido){
         dynamoDBMapper.save(pedido);
         return pedido;
    }
}
