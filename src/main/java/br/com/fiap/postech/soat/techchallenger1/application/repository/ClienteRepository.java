package br.com.fiap.postech.soat.techchallenger1.application.repository;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.ClienteRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepository {
    @Autowired
    ClienteRepositoryDB clienteRepository;



    public void cadastrarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Optional<Cliente> findByCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

}
