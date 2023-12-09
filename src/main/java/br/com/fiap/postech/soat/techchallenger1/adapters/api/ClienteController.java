package br.com.fiap.postech.soat.techchallenger1.adapters.api;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.application.ClienteService;
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
    @PostMapping("/cliente")
    public ResponseEntity<ClienteDto> cadastroCliente(@RequestBody ClienteDto cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
