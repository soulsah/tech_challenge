package br.com.fiap.postech.soat.techchallenger1.domain.repository;

import br.com.fiap.postech.soat.techchallenger1.adapters.repository.ProdutoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {
    @Autowired
    ProdutoRepositoryDB produtoRepositoryDB;

    public List<Produto> findAll(){ return produtoRepositoryDB.findAll(); }
    public Produto findProdutoById(Long produto_id){ return produtoRepositoryDB.findProdutoById(produto_id); }

    public Produto cadastrarProduto(Produto produto){ return produtoRepositoryDB.save(produto);}

    public Produto deleteById(Long produto_id){
        produtoRepositoryDB.deleteById(produto_id);
        return null;
    }
}
