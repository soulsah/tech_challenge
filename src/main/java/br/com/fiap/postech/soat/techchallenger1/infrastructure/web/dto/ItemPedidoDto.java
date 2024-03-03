package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDto {
    private Long pedidoId;
    private Long produto;
    private int quantidade;

    public ItemPedidoDto(ItemPedido itemPedido){
        this.pedidoId = itemPedido.getPedidoId();
        this.produto = itemPedido.getProduto();
        this.quantidade = itemPedido.getQuantidade();
    }
}
