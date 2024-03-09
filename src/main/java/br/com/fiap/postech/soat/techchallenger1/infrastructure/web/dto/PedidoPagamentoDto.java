package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

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
}
