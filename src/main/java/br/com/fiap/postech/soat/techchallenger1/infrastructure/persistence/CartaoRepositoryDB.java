package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CartaoRepositoryDB  {

    private DynamoDBMapper dynamoDBMapper;

    public Cartao save(Cartao cartao) {
        dynamoDBMapper.save(cartao);
        return cartao;
    }


    public Cartao findById(Long id) {
        return dynamoDBMapper.load(Cartao.class, id);
    }


    public void deleteById(Long id) {
        Cartao cartao = dynamoDBMapper.load(Cartao.class, id);
        dynamoDBMapper.delete(cartao);
    }

    public List<Cartao> findAll() {

        return dynamoDBMapper.scan(Cartao.class,new DynamoDBScanExpression());
    }
}
