package br.com.fiap.postech.soat.techchallenger1.application;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProdutoService{
    List<Produto> findAll();

    Produto findProdutoById(Long produto_id);

    List<Produto> findProdutosByTipo(Long tipo);

    void cadastrarProduto(ProdutoDto produto);

    Produto deleteById(Long produto_id);
}
