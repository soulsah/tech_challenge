package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.ClienteService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public boolean criarUsuario(Cliente cliente) {
        return false;
    }
}
