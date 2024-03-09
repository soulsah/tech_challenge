package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PedidoRepositoryDB extends JpaRepository<Pedido,Long> {


    @Query(value = "SELECT SUM(tip.preco) FROM tb_produto tip LEFT JOIN tb_itens_pedido tp ON tip.id = tp.produto WHERE tp.pedido_id = :pedidoId GROUP BY tp.pedido_id", nativeQuery = true)
    double getValorTotal(@Param("pedidoId") Long pedidoId);

    List<Pedido> findAll();

    List<Pedido> findPedidosByClienteId(Long id);

    Pedido findPedidoById(Long id);

    Pedido save(Pedido pedido);
}
