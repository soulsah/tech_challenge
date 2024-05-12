package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pagamentos;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PagamentoRepositoryDB {


    private DynamoDBMapper dynamoDBMapper;

    public Optional<Pagamentos> findByPedidoId(long pedidoId){
        DynamoDBQueryExpression<Pagamentos> queryExpression = new DynamoDBQueryExpression<Pagamentos>()
                .withIndexName("ClienteIDIndex")
                .withKeyConditionExpression("pedidoId = :v1")
                .withExpressionAttributeValues(new HashMap<String, AttributeValue>() {{
                    put(":v1", new AttributeValue().withN(String.valueOf(pedidoId)));
                }});

        PaginatedQueryList<Pagamentos> paginatedResults = dynamoDBMapper.query(Pagamentos.class, queryExpression);

        if (!paginatedResults.isEmpty()) {
            return Optional.of(paginatedResults.get(0));
        } else {
            return Optional.empty();
        }
    }

    public Pagamentos save(Pagamentos pagamento) {
        dynamoDBMapper.save(pagamento);
        return pagamento;
    }


    public Pagamentos findById(Long id) {
        return dynamoDBMapper.load(Pagamentos.class, id);
    }


    public void deleteById(Long id) {
        Pagamentos pagamento = dynamoDBMapper.load(Pagamentos.class, id);
        dynamoDBMapper.delete(pagamento);
    }

    public List<Pagamentos> findAll() {

        return dynamoDBMapper.scan(Pagamentos.class,new DynamoDBScanExpression());
    }
}
