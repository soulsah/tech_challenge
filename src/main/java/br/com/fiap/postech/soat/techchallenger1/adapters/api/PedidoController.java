package br.com.fiap.postech.soat.techchallenger1.adapters.api;
import br.com.fiap.postech.soat.techchallenger1.application.FakeCheckoutService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.FakeCheckout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.PedidoDto;

@RestController
public class PedidoController {

    @Autowired
    private FakeCheckoutService checkoutService;

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

    @PostMapping("/pedidos/{id}/checkout")
    public ResponseEntity<FakeCheckout> checkoout(@RequestBody PedidoDto pedido){
        return null;
    }
}
