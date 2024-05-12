package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TipoProdutoRepositoryDb  {

    private DynamoDBMapper dynamoDBMapper;

    public TipoProduto save(TipoProduto tipoProduto) {
        dynamoDBMapper.save(tipoProduto);
        return tipoProduto;
    }


    public TipoProduto findById(Long id) {
        return dynamoDBMapper.load(TipoProduto.class, id);
    }


    public void deleteById(Long id) {
        TipoProduto TipoProduto = dynamoDBMapper.load(TipoProduto.class, id);
        dynamoDBMapper.delete(TipoProduto);
    }

    public List<TipoProduto> findAll() {

        return dynamoDBMapper.scan(TipoProduto.class,new DynamoDBScanExpression());
    }
}
