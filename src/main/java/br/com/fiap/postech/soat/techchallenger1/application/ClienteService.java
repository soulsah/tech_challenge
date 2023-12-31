package br.com.fiap.postech.soat.techchallenger1.application;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CpfNaoEncontradoException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;

public interface ClienteService {

    public void criarUsuario(ClienteDto cliente) throws CadastroClienteException;

    public ClienteDto findByCpf(String cpf) throws CpfNaoEncontradoException;
}
