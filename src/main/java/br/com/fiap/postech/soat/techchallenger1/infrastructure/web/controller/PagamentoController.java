package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;


import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PagamentoNaoEncontradoException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.application.service.PagamentoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {


    @Autowired
    private PagamentoService pagamentoService;

    @Operation(summary = "Efetuar o checkout do pagamento",
            description = "Efetua o pagamento do pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pagamento efetuado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada incorretos")
    })
    @PostMapping("/checkout")
    public ResponseEntity<PagamentoResponseDto> checkout(@RequestBody CheckoutDto checkoutDto) throws PedidoException, CardNotFoundException {

        var checkout = pagamentoService.checkout(checkoutDto);
        return ResponseEntity.ok().body(checkout);
    }

    @Operation(summary = "Verificar o status do pagamento",
            description = "Verificar o status do pagamento")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pagamento encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada incorretos")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PagamentosDto>getPagamento(@PathVariable Long id) throws PagamentoNaoEncontradoException {
       return ResponseEntity.ok().body(pagamentoService.getPagamentoById(id));
    }
}
