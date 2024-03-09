package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;


import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.DadosPagamentoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PagamentoResponseDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoPagamentoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PagamentoController {

    @Value("${endpoint.pagamento}")
    private String endpoint;

    @GetMapping("/checkout")
    public ResponseEntity<PagamentoResponseDto> checkout(){

        /**
         * TODO
         * implementar a logica de pagamentos.
         */

        PedidoPagamentoDto pedido = new PedidoPagamentoDto();
        pedido.setPedidoId(2);
        pedido.setValorTotal(75.98);

        DadosPagamentoDto dadosPagamento = new DadosPagamentoDto();
        dadosPagamento.setTipoPagamento("Crédito");
        dadosPagamento.setNumCartao("1234324355764563");
        dadosPagamento.setCvv("432");
        dadosPagamento.setValidade("12/30/2030");

        pedido.setDadosPagamento(dadosPagamento);
        RestTemplate rest = new RestTemplate();
        var a = rest.postForEntity(endpoint,pedido, PagamentoResponseDto.class);

        return ResponseEntity.ok().body(a.getBody());
    }

}
