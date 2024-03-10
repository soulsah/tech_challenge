package br.com.fiap.postech.soat.techchallenger1.application.service.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.application.repository.TipoProdutoRepository;
import br.com.fiap.postech.soat.techchallenger1.application.service.TipoProdutoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.TipoProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TipoProdutoServiceImpl implements TipoProdutoService {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Override
    public List<TipoProdutoDto> getAllTipoProduto() {
        var retorno =  tipoProdutoRepository.getAll();

        return retorno.stream().map(TipoProdutoDto::new).collect(Collectors.toList());
    }

    @Override
    public TipoProdutoDto getTipoProdutoById(Long id) throws TipoProdutoNaoCadastradoException {
        var tipoProduto = tipoProdutoRepository.getTipoProdutoById(id);
        TipoProdutoDto tipoProdutoDto = new TipoProdutoDto(tipoProduto.getId(), tipoProduto.getDescricao());

        return tipoProdutoDto;

    }

    @Override
    public TipoProdutoDto createTipoProduto(TipoProdutoDto tipoProdutoDto) {

        var tipoProduto =  tipoProdutoRepository.createTipoProduto(new TipoProduto(tipoProdutoDto));

        return new TipoProdutoDto(tipoProduto);
    }


}
