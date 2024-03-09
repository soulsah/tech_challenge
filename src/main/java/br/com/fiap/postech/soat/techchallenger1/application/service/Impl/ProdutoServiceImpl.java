package br.com.fiap.postech.soat.techchallenger1.application.service.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.application.service.ProdutoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import br.com.fiap.postech.soat.techchallenger1.application.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public void cadastrarProduto(ProdutoDto produto) throws TipoProdutoNaoCadastradoException {
        try{
        produtoRepository.cadastrarProduto(new Produto(produto));

        }catch(DataIntegrityViolationException ex){
            throw new TipoProdutoNaoCadastradoException("tipo de produto não cadastrado");
        }
    }

    @Override
    public Produto deleteById(Long produto_id){
        return produtoRepository.deleteById(produto_id);
    }
}
