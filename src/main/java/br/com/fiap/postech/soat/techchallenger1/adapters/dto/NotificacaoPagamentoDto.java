package br.com.fiap.postech.soat.techchallenger1.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoPagamentoDto {
    private String status;
    private String mensagem;
}
