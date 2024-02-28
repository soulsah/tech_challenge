package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.application.service.ClienteService;
<<<<<<< HEAD
import br.com.fiap.postech.soat.techchallenger1.application.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.CpfNaoEncontradoException;
=======
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CpfNaoEncontradoException;
>>>>>>> e77518c0e3dfbb4069ea381664d56ab75376a827
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Operation(summary = "Cria um cliente",
            description = "Cria um cliente na base de dados do sistema, o nome,cpf e o e-mail devem ser validos e são de preenchimento obrigatório")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Cliente ja cadastrado")
    })
    @PostMapping("/cliente")
    public ResponseEntity cadastroCliente(@RequestBody @Valid ClienteDto cliente) throws CadastroClienteException {
        clienteService.criarUsuario(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario cadastrado com sucesso");
    }

    @Operation(summary = "Busca um cliente",
            description = "Busca um cliente com base no cpf")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente Encontrado"),
            @ApiResponse(responseCode = "400", description = "Cpf não está cadastrado"),
    })
    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<ClienteDto> findClientByCpf(@PathVariable String cpf) throws CpfNaoEncontradoException {
       return ResponseEntity.ok().body(clienteService.findByCpf(cpf));
    }
}
