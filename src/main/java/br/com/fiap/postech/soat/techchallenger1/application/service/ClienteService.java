package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CpfNaoEncontradoException;

public interface ClienteService {

    public void criarUsuario(ClienteDto cliente) throws CadastroClienteException;

    public ClienteDto findByCpf(String cpf) throws CpfNaoEncontradoException;
}
