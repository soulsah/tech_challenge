package br.com.fiap.postech.soat.techchallenger1.domain.model;


import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ItemPedidoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_itens_pedido")
@IdClass(ItemPedidoId.class)
public class ItemPedido {
    @Id
    @JoinColumn(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Id
    @JoinColumn(name = "produto", nullable = false)
    private Long produto;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public ItemPedido(ItemPedidoDto itemPedidoDto){
        this.pedidoId = itemPedidoDto.getPedidoId();
        this.produto = itemPedidoDto.getProduto();
        this.quantidade = itemPedidoDto.getQuantidade();
    }

}
