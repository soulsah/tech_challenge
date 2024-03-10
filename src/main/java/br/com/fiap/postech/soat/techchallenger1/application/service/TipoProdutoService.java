package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.TipoProdutoDto;

import java.util.List;

public interface TipoProdutoService {
    List<TipoProdutoDto> getAllTipoProduto();

    TipoProdutoDto getTipoProdutoById(Long id) throws TipoProdutoNaoCadastradoException;

    TipoProdutoDto createTipoProduto(TipoProdutoDto tipoProdutoDto);

}
