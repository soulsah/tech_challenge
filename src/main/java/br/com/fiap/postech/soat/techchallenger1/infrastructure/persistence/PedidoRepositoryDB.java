package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PedidoRepositoryDB extends JpaRepository<Pedido,Long> {

    List<Pedido> findAll();

    List<Pedido> findPedidosByClienteId(Long id);

    Pedido findPedidoById(Long id);

    Pedido save(Pedido pedido);
}
