package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.application.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.CpfNaoEncontradoException;

public interface ClienteService {

    void criarUsuario(ClienteDto cliente) throws CadastroClienteException;

    ClienteDto findByCpf(String cpf) throws CpfNaoEncontradoException;
}
