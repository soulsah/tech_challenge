package br.com.fiap.postech.soat.techchallenger1.adapters.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.StatusPedido;

public record PedidoDto(Long id, Long cliente_id, Enum<StatusPedido> status) {
}
