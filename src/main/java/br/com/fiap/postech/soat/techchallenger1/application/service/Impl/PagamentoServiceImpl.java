package br.com.fiap.postech.soat.techchallenger1.application.service.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PagamentoNaoEncontradoException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
import br.com.fiap.postech.soat.techchallenger1.application.repository.PagamentoRepository;
import br.com.fiap.postech.soat.techchallenger1.application.service.CartaoService;
import br.com.fiap.postech.soat.techchallenger1.application.service.PagamentoService;
import br.com.fiap.postech.soat.techchallenger1.application.service.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pagamentos;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.*;
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

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public PagamentoResponseDto checkout(CheckoutDto checkoutDto) throws CardNotFoundException {

        var cartao = cartaoService.getCardById(checkoutDto.getCardId());
        var valorTotal = pedidoService.getValorTotal(checkoutDto.getPedidoId());


        PedidoPagamentoDto pedido = new PedidoPagamentoDto(checkoutDto.getPedidoId(),valorTotal,cartao);


        RestTemplate rest = new RestTemplate();
        var response =  rest.postForEntity(endpoint,pedido, PagamentoResponseDto.class);

        var pagamentos = montaPagamento(valorTotal,checkoutDto.getCardId(),checkoutDto.getPedidoId(),response.getBody().getStatus());

        System.out.println("Status do pagamento response: "+response.getBody().getStatus());
        pagamentoRepository.save(pagamentos);
        return response.getBody();

    }

    @Override
    public PagamentosDto getPagamentoById(Long id) throws PagamentoNaoEncontradoException {
        var pagamento = pagamentoRepository.getPagamentoById(id);

        PagamentosDto pagamentoDto = new PagamentosDto(pagamento);
        return pagamentoDto;
    }

    @Override
    public void updatePaymentStatus(NotificacaoPagamentoDto notificacaoPagamentoDto) throws PagamentoNaoEncontradoException {
      var pagamento =   pagamentoRepository.findByIdPedido(notificacaoPagamentoDto.getIdPedido());
      if(!pagamento.isPresent())
          throw new PagamentoNaoEncontradoException("Pagamento não encontrado");
      pagamento.get().setStatus(notificacaoPagamentoDto.getStatus());
      pagamentoRepository.save(pagamento.get());
    }

    private Pagamentos montaPagamento(double valorTotal, long cardId, long pedidoId,String status){
        Pagamentos pagamentos = new Pagamentos();
        pagamentos.setValor(valorTotal);
        pagamentos.setCardId(cardId);
        pagamentos.setPedidoId(pedidoId);
        pagamentos.setStatus(status);
        return pagamentos;
    }

}
