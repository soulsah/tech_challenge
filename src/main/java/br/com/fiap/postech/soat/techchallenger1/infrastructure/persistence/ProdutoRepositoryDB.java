package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ProdutoRepositoryDB  {

    private DynamoDBMapper dynamoDBMapper;

    public List<Produto> findAll(){
        return dynamoDBMapper.scan(Produto.class,new DynamoDBScanExpression());
    }

    public Produto findProdutoById(Long id){
        return dynamoDBMapper.load(Produto.class, id);
    }

    public List<Produto> findProdutosByTipo(TipoProduto tipo){
        List<Produto> allProdutos = dynamoDBMapper.scan(Produto.class, new DynamoDBScanExpression());
        return allProdutos.stream()
                .filter(produto -> produto.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    public Produto save(Produto produto){
        dynamoDBMapper.save(produto);
        return produto;
    }

   public void deleteById(Long id){
        Produto produto = dynamoDBMapper.load(Produto.class, id);
        dynamoDBMapper.delete(produto);
    }
}
