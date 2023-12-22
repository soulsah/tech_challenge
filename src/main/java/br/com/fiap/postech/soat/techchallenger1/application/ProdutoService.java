package br.com.fiap.postech.soat.techchallenger1.application;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProdutoService{
    public List<Produto> findAll();

    public Produto findProdutoById(Long produto_id);
}
