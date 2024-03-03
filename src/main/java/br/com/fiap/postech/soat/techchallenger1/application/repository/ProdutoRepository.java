package br.com.fiap.postech.soat.techchallenger1.application.repository;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.ProdutoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {
    @Autowired
    ProdutoRepositoryDB produtoRepositoryDB;

    public List<Produto> findAll(){ return produtoRepositoryDB.findAll(); }
    public Produto findProdutoById(Long produto_id){ return produtoRepositoryDB.findProdutoById(produto_id); }

    public List<Produto> findProdutosByTipo(Long tipo){
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setId(tipo);
        return produtoRepositoryDB.findProdutosByTipo(tipoProduto);
    }

    public void cadastrarProduto(Produto produto){ produtoRepositoryDB.save(produto);}

    public Produto deleteById(Long produto_id){
        produtoRepositoryDB.deleteById(produto_id);
        return null;
    }
}
