package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;


import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.application.service.PagamentoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CheckoutDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.DadosPagamentoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PagamentoResponseDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoPagamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PagamentoController {



    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/checkout")
    public ResponseEntity<PagamentoResponseDto> checkout(@RequestBody CheckoutDto checkoutDto) throws PedidoException, CardNotFoundException {

        var checkout = pagamentoService.checkout(checkoutDto);
        return ResponseEntity.ok().body(checkout);
    }

}
