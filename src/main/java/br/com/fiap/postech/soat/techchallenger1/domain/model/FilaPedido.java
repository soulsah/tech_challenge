package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.FilaPedidoDto;
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
@DynamoDBTable(tableName = "tb_fila_pedidos")
@IdClass(FilaPedidoId.class)
public class FilaPedido {
    @DynamoDBHashKey
    private Long pedidoId;

    @DynamoDBHashKey
    private Long clienteId;

    @DynamoDBAttribute
    private StatusPedido statusPedido;

    public FilaPedido(FilaPedidoDto filaPedidoDto){
        this.pedidoId = filaPedidoDto.getPedidoId();
        this.clienteId = filaPedidoDto.getClienteId();
        this.statusPedido = filaPedidoDto.getStatusPedido();
    }
}
