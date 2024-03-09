package br.com.fiap.postech.soat.techchallenger1.application.service.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.application.service.CartaoService;
import br.com.fiap.postech.soat.techchallenger1.application.service.PagamentoService;
import br.com.fiap.postech.soat.techchallenger1.application.service.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CheckoutDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.DadosPagamentoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PagamentoResponseDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoPagamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PagamentoServiceImpl implements PagamentoService {


    @Value("${endpoint.pagamento}")
    private String endpoint;

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private PedidoService pedidoService;

    @Override
    public PagamentoResponseDto checkout(CheckoutDto checkoutDto) throws CardNotFoundException, PedidoException {

        var cartao = cartaoService.getCardById(checkoutDto.getCardId());
        var valorTotal = pedidoService.getValorTotal(checkoutDto.getPedidoId());


        PedidoPagamentoDto pedido = new PedidoPagamentoDto(checkoutDto.getPedidoId(),valorTotal,cartao);


        RestTemplate rest = new RestTemplate();
        var a =  rest.postForEntity(endpoint,pedido, PagamentoResponseDto.class);
        return a.getBody();

    }
}
