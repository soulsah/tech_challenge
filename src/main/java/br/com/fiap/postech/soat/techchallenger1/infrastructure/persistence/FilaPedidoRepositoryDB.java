package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FilaPedidoRepositoryDB extends JpaRepository<FilaPedido,Long> {
    FilaPedido findFilaPedidoByPedidoId(Long id);
}
