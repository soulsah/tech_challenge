package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ClienteRepositoryDB  extends JpaRepository<Cliente,Long> {
    public Cliente save(Cliente cliente) ;


    Optional<Cliente> findByCpf(String cpf);
}
