package br.com.fiap.postech.soat.techchallenger1.adapters.repository;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProdutoRepositoryDB extends JpaRepository<Produto,Long> {
    @Query(
            value = "SELECT * FROM tb_produto WHERE ID = :produto_id",
            nativeQuery = true)
    public Produto findProdutoById(@Param("produto_id") Long produto_id);

    @Query(
            value = "SELECT * FROM tb_produto",
            nativeQuery = true)
    public List<Produto> findAll();

    public Produto save(Produto produto);
}
