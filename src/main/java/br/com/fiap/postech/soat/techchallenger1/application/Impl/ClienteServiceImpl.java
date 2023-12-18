package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.application.ClienteService;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import br.com.fiap.postech.soat.techchallenger1.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public void criarUsuario(ClienteDto cliente) throws CadastroClienteException {
        try {
            /**
             * TODO
             * fazer validacao se o cpf ou email do cliente ja esta cadastrado no banco.
             * se estiver retornar a exception no catch
             */
            clienteRepository.cadastrarCliente(new Cliente(cliente));
        } catch (Exception e) {
            throw new CadastroClienteException("Erro ao cadastrar cliente");
        }
    }
}
