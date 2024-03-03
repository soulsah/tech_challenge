package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovoPedidoDto {
    private PedidoDto pedido;
    private List<ItemPedidoDto> itensPedido;
}
