package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;

import java.util.List;

public interface ProdutoService{
    List<Produto> findAll();

    Produto findProdutoById(Long produto_id);

    List<Produto> findProdutosByTipo(Long tipo);

    void cadastrarProduto(ProdutoDto produto) throws TipoProdutoNaoCadastradoException;

    Produto deleteById(Long produto_id);
}
