package br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagamentoRepositoryDB extends JpaRepository<Pagamentos, Long> {

    @Query(value="select * from tb_pagamento tp where pedido_id = :pedidoId",nativeQuery = true)
    Optional<Pagamentos> findByPedidoId(long pedidoId);
}
