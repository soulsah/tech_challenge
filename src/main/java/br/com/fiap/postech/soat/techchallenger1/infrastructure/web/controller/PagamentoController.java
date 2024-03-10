package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;


import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.application.service.PagamentoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CheckoutDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.DadosPagamentoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PagamentoResponseDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoPagamentoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
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

}
