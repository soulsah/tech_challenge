package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepositoryDB extends JpaRepository<Pagamentos, Long> {
}
