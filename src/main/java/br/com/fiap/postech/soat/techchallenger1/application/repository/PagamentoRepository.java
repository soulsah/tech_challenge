package br.com.fiap.postech.soat.techchallenger1.application.repository;

import br.com.fiap.postech.soat.techchallenger1.application.exception.PagamentoNaoEncontradoException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pagamentos;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.PagamentoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.NotificacaoPagamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PagamentoRepository {


    @Autowired
    private PagamentoRepositoryDB pagamentoRepositoryDB;

    public void save(Pagamentos pagamento) {
        pagamentoRepositoryDB.save(pagamento);
    }

    public Pagamentos getPagamentoById(Long id) throws PagamentoNaoEncontradoException {
        var pagamento = pagamentoRepositoryDB.findById(id);

        if(!pagamento.isPresent())
            throw new PagamentoNaoEncontradoException("pagamento Não existe");


        return pagamento.get();
    }

}
