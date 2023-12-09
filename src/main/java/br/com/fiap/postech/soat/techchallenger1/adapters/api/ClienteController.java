package br.com.fiap.postech.soat.techchallenger1.adapters.api;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClienteController {

    @PostMapping("/cliente")
    public ResponseEntity<ClienteDto> cadastroCliente(@RequestBody ClienteDto cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
