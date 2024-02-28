package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ClienteDto;
<<<<<<< HEAD
import br.com.fiap.postech.soat.techchallenger1.application.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.CpfNaoEncontradoException;
=======
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CpfNaoEncontradoException;
>>>>>>> e77518c0e3dfbb4069ea381664d56ab75376a827

public interface ClienteService {

    public void criarUsuario(ClienteDto cliente) throws CadastroClienteException;

    public ClienteDto findByCpf(String cpf) throws CpfNaoEncontradoException;
}
