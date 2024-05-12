package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoDto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "tb_pedido")
public class Pedido {
    @DynamoDBHashKey
    private Long id;

    @DynamoDBAttribute
    private Long clienteId;

    @DynamoDBAttribute
    private StatusPedido status;

    public Pedido(PedidoDto pedidoDto){
        this.id = pedidoDto.getId();
        this.clienteId = pedidoDto.getClienteId();
        this.status = pedidoDto.getStatus();
    }
}
