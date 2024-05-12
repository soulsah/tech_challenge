package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class FilaPedidoRepositoryDB {

    private DynamoDBMapper dynamoDBMapper;

    public FilaPedido findFilaPedidoByPedidoId(Long id){
        return dynamoDBMapper.load(FilaPedido.class, id);

    }

    public FilaPedido save(FilaPedido filaPedido) {
        dynamoDBMapper.save(filaPedido);
        return filaPedido;
    }
}
