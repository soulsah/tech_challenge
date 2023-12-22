package br.com.fiap.postech.soat.techchallenger1.adapters.repository;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
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

    @Query(
            value = "SELECT * FROM tb_pedido WHERE Cliente_ID = :cliente_id",
            nativeQuery = true)
    public List<Pedido> findPedidoByCliente(@Param("cliente_id") Long cliente_id);

    @Query(
            value = "SELECT * FROM tb_pedido",
            nativeQuery = true)
    public List<Pedido> findAll();
}
