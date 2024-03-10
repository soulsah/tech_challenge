package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoPagamentoDto {
    private int pedidoId;
    private double valorTotal;
    private DadosPagamentoDto dadosPagamento;


    public PedidoPagamentoDto(long pedidoId, double valorTotal, CartaoDto cartao){
        this.setPedidoId((int)pedidoId);
        this.setValorTotal(valorTotal);


        DadosPagamentoDto dadosPagamento = new DadosPagamentoDto();
        dadosPagamento.setTipoPagamento("Crédito");
        dadosPagamento.setNumCartao(cartao.getCardHolderName());
        dadosPagamento.setCvv(cartao.getCvv());
        dadosPagamento.setValidade(cartao.getExpirationDate());

        this.setDadosPagamento(dadosPagamento);
    }


}
