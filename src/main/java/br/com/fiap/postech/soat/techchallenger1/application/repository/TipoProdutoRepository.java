package br.com.fiap.postech.soat.techchallenger1.application.repository;

import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.TipoProdutoRepositoryDb;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.TipoProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoProdutoRepository {

    @Autowired
    private TipoProdutoRepositoryDb tipoProdutoRepositoryDb;

    public List<TipoProduto> getAll() {
        return tipoProdutoRepositoryDb.findAll();
    }

    public TipoProduto getTipoProdutoById(Long id) throws TipoProdutoNaoCadastradoException {
       var tipoProduto = tipoProdutoRepositoryDb.findById(id);

        if(tipoProduto == null)
            throw new TipoProdutoNaoCadastradoException("Tipo Produto Não existe");


       return tipoProduto;
    }

    public TipoProduto createTipoProduto(TipoProduto tipoProdutoDto) {
        return tipoProdutoRepositoryDb.save(tipoProdutoDto);
    }

    public void deleteTipoProduto(Long id) {
        tipoProdutoRepositoryDb.deleteById(id);
    }
}
