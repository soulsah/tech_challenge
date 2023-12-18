package br.com.fiap.postech.soat.techchallenger1.domain.repository;

import br.com.fiap.postech.soat.techchallenger1.adapters.repository.ClienteRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {
    @Autowired
    ClienteRepositoryDB clienteRepository;



    public void cadastrarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
