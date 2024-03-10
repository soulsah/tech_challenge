package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoPagamentoDto {
    @JsonProperty("status")
    private String status;
    @JsonProperty("id_pedido")
    private long idPedido;
}
