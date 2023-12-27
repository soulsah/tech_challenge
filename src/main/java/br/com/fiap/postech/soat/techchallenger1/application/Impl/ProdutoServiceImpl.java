package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.application.ProdutoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import br.com.fiap.postech.soat.techchallenger1.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findProdutoById(Long produto_id) {
        return produtoRepository.findProdutoById(produto_id);
    }

    @Override
    public List<Produto> findProdutosByTipo(Long tipo) { return produtoRepository.findProdutosByTipo(tipo);}

    @Override
    public Produto cadastrarProduto(ProdutoDto produto){
        return produtoRepository.cadastrarProduto(new Produto(produto));
    }

    @Override
    public Produto deleteById(Long produto_id){
        return produtoRepository.deleteById(produto_id);
    }
}
