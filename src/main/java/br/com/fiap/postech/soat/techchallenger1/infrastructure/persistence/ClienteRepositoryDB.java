package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ClienteRepositoryDB   {
    private DynamoDBMapper dynamoDBMapper;

    public Cliente save(Cliente cliente) {
        dynamoDBMapper.save(cliente);
        return cliente;
    }


    public Cliente findById(Long id) {
        return dynamoDBMapper.load(Cliente.class, id);
    }


    public void deleteById(Long id) {
        Cliente cartao = dynamoDBMapper.load(Cliente.class, id);
        dynamoDBMapper.delete(cartao);
    }

    public List<Cliente> findAll() {

        return dynamoDBMapper.scan(Cliente.class,new DynamoDBScanExpression());
    }

    public Optional<Cliente> findByCpf(String cpf) {
        return Optional.of(dynamoDBMapper.load(Cliente.class, cpf));
    }

}