package br.com.fiap.postech.soat.techchallenger1.application.repository;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pagamentos;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.PagamentoRepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PagamentoRepository {


    @Autowired
    private PagamentoRepositoryDB pagamentoRepositoryDB;

    public void save(Pagamentos pagamento) {
        pagamentoRepositoryDB.save(pagamento);
    }
}
