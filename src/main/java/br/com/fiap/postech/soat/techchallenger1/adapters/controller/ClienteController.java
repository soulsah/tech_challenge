package br.com.fiap.postech.soat.techchallenger1.adapters.controller;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.application.ClienteService;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}