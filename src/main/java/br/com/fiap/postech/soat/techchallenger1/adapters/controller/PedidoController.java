package br.com.fiap.postech.soat.techchallenger1.adapters.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.PedidoDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PedidoController {

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<PedidoDto> getPedidoById(@RequestBody PedidoDto pedido){
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pedido);
        }

        return ResponseEntity.ok(pedido);
    }

    @PostMapping("/pedidos/{id}")
    public ResponseEntity<PedidoDto> criaPedidoById(@RequestBody PedidoDto pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
