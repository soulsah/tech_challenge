package br.com.fiap.postech.soat.techchallenger1.domain.model;


import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ItemPedidoDto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "tb_itens_pedido")
@IdClass(ItemPedidoId.class)
public class ItemPedido {
    @DynamoDBHashKey
    private Long pedidoId;

    @DynamoDBHashKey
    private Long produto;

    @DynamoDBAttribute
    private int quantidade;

    public ItemPedido(ItemPedidoDto itemPedidoDto){
        this.pedidoId = itemPedidoDto.getPedidoId();
        this.produto = itemPedidoDto.getProduto();
        this.quantidade = itemPedidoDto.getQuantidade();
    }

}
