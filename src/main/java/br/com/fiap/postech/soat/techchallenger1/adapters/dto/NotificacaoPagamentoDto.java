package br.com.fiap.postech.soat.techchallenger1.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoPagamentoDto {
    @JsonProperty("pedidoId")
    private int pedidoId;

    @JsonProperty("status")
    private String status;
}
