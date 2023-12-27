package br.com.fiap.postech.soat.techchallenger1.adapters.repository;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProdutoRepositoryDB extends JpaRepository<Produto,Long> {

    List<Produto> findAll();

    Produto findProdutoById(Long id);

    List<Produto> findProdutosByTipo(TipoProduto tipo);

    Produto save(Produto produto);

    void deleteById(Long id);
}
